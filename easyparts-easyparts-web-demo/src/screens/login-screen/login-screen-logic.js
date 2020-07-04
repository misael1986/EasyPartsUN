import cognito from "../../cognito/cognito";
import { UserStore } from "../../stores";

export function signUp(history) {
  cognito.userPool.signUp(
    UserStore.email,
    UserStore.password,
    [],
    null,
    (err, data) => {
      if (err) {
        console.log(err);
        if (err.code === "UsernameExistsException") {
          logIn(history);
        } else {
          alert("Error al registrar el usuario");
        }
      } else {
        console.log(data);
        alert("Bienvenido a EasyParts!");
        history.push("/verify");
      }
    }
  );
}

export function logIn(history) {
  console.log(cognito.user);
  console.log(cognito.authDetails);
  cognito.user.authenticateUser(cognito.authDetails, {
    onSuccess: (data) => {
      console.log(data);
      UserStore.loggedIn = true;
      history.push(UserStore.routeOrigin);
    },
    onFailure: (err) => {
      console.log(err);
      if (err.code === "UserNotConfirmedException") {
        history.push("/verify");
      } else if (err.code === "NotAuthorizedException") {
        if (err.message === "Password attempts exceeded") {
          alert("Ha excedido el número de intentos fallidos");
        } else {
          alert("Usuario o contraseña incorrecto");
        }
      }
    },
    newPasswordRequired: (data) => {
      console.log("newPasswordRequired: ", data);
    },
  });
}
