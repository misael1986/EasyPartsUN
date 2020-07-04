import cognito from "../../cognito/cognito";
import { UserStore } from "../../stores";

export function verify(history) {
  cognito.user.confirmRegistration(UserStore.otp, true, (err, data) => {
    if (err) {
      console.log(err);
      alert("Código de verificación incorrecto");
    } else {
      console.log(data);
      UserStore.loggedIn = true;
      history.push(UserStore.routeOrigin);
      alert("Hemos verificado tu cuenta exitosamente!");
    }
  });
}

export function resend() {
  cognito.user.resendConfirmationCode((err, data) => {
    if (err) {
      console.log(err);
      alert("Hubo un error al reenviar el código");
    } else {
      console.log(data);
      alert("Código enviado exitosamente");
    }
  });
}
