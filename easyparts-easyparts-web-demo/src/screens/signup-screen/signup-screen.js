import React from "react";
import "./signup-screen.css";
import { signUp } from "../login-screen/login-screen-logic";
import { inject, observer } from "mobx-react";
import Button from "@material-ui/core/Button";
import TextField from "@material-ui/core/TextField";
import AccountCircleIcon from "@material-ui/icons/AccountCircle";
import { useHistory } from "react-router-dom";

function SignUpScreen({ userStore }) {
  const history = useHistory();

  return (
    <div id="signupScreen">
      <div className="izqSignUp">
        <h1 className="labelRegistrarse">Registro</h1>
        <AccountCircleIcon className="avatar" style={{ fontSize: 180 }} />
        <div className="form">
          <TextField
            variant="outlined"
            margin="normal"
            required
            fullWidth
            id="email"
            label="Correo Electrónico"
            name="email"
            autoComplete="email"
            autoFocus
            value={userStore.email}
            onChange={(event) => (userStore.email = event.target.value)}
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
            onClick={() => signUp(history)}
          >
            Registrarse
          </Button>
        </div>
      </div>

      <div className="derSignUp">
        <h1 style={{ fontSize: "100px" }}>EasyParts</h1>
      </div>
    </div>
  );
}

export default inject("userStore")(observer(SignUpScreen));
