import cognito from "../../cognito/cognito";

export function forgot(history) {
  cognito.user.forgotPassword({
    onSuccess: (data) => {
      console.log(data);
      history.push("/");
      history.push("/newPassword");
    },
    onFailure: (err) => {
      console.log(err);
      if (err.code === "LimitExceededException") {
        alert("Ha excedido el número de intentos fallidos");
      } else {
        alert("Hubo un error al verificar este correo");
      }
    },
  });
}
