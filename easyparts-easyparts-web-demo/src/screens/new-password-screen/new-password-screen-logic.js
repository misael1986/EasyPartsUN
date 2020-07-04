import cognito from "../../cognito/cognito";
import { UserStore } from "../../stores";

export function newPassword(history) {
  cognito.user.confirmPassword(UserStore.otp, UserStore.password, {
    onSuccess: (data) => {
      console.log(data);
      UserStore.loggedIn = true;
      history.push(UserStore.routeOrigin);

      setTimeout(() => {
        alert("Has cambiado tu contraseña de forma exitosa!");
      }, 200);
    },
    onFailure: (err) => {
      console.log(err);
      alert("Algún dato es erróneo");
    },
  });
}
