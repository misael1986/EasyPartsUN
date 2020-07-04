import React, { useEffect } from "react";
import "./new-password-screen.css";
import { inject, observer } from "mobx-react";
import Button from "@material-ui/core/Button";
import TextField from "@material-ui/core/TextField";
import SaveIcon from "@material-ui/icons/Save";
import AccountCircleIcon from "@material-ui/icons/AccountCircle";
import { useHistory } from "react-router-dom";
import { newPassword } from "./new-password-screen-logic";

function NewPasswordScreen({ userStore }) {
  const history = useHistory();

  useEffect(() => {
    alert("Hemos enviado un código de verificación a tu correo");
  }, []);

  return (
    <div id="NewPasswordScreen">
      <div className="izqNewPassword">
        <h1 className="labelRegistrarse">Nueva Contraseña</h1>
        <AccountCircleIcon className="avatar" style={{ fontSize: 180 }} />
        <div className="form">
          <TextField
            variant="outlined"
            margin="normal"
            required
            fullWidth
            id="verify"
            label="Código de verificación"
            name="otp"
            autoFocus
            value={userStore.otp}
            onChange={(event) => (userStore.otp = event.target.value)}
          />
          <TextField
            variant="outlined"
            margin="normal"
            required
            fullWidth
            name="password"
            label="Contraseña"
            type="password"
            id="password"
            autoComplete="current-password"
            value={userStore.password}
            onChange={(event) => (userStore.password = event.target.value)}
          />
          <p className="validarContraseña">
            La contraseña debe ser mínimo de 8 caracteres y contener al menos
            una letra minúscula, una mayúscula, un número y un carácter
            especial.
          </p>

          <br />
          <br />

          <Button
            type="submit"
            fullWidth
            variant="contained"
            color="primary"
            className="submit"
            startIcon={<SaveIcon />}
            onClick={() => newPassword(history)}
          >
            Guardar
          </Button>
        </div>
      </div>

      <div className="derNewPassword">
        <h1 style={{ fontSize: "100px" }}>EasyParts</h1>
      </div>
    </div>
  );
}

export default inject("userStore")(observer(NewPasswordScreen));
