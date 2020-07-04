import React from "react";
import "./forgot-screen.css";
import { inject, observer } from "mobx-react";
import Button from "@material-ui/core/Button";
import TextField from "@material-ui/core/TextField";
import { Link, useHistory } from "react-router-dom";
import SendIcon from "@material-ui/icons/Send";
import AccountCircleIcon from "@material-ui/icons/AccountCircle";
import { forgot } from "./forgot-screen-logic";

function ForgotScreen({ userStore }) {
  const history = useHistory();

  return (
    <div id="forgotScreen">
      <div className="izqForgot">
        <h1 style={{ fontSize: "100px" }}>EasyParts</h1>
      </div>

      <div className="derForgot">
        <h1 className="labelRegistrarse">Olvide mi contraseña</h1>
        <AccountCircleIcon className="avatar" style={{ fontSize: 180 }} />
        <div className="form">
          <TextField
            variant="outlined"
            margin="normal"
            required
            fullWidth
            id="email"
            label="Escribe Tu Correo Electrónico Para Cambiar Tu Contraseña"
            name="email"
            autoComplete="email"
            autoFocus
            value={userStore.email}
            onChange={(event) => (userStore.email = event.target.value)}
          />

          <br />
          <br />

          <Button
            type="submit"
            fullWidth
            variant="contained"
            color="primary"
            className="submit"
            endIcon={<SendIcon />}
            onClick={() => forgot(history)}
          >
            <Link to="/newpassword" className="enviar">
              Enviar
            </Link>
          </Button>
        </div>
      </div>
    </div>
  );
}

export default inject("userStore")(observer(ForgotScreen));
