import React, { useEffect } from "react";
import "./verify-screen.css";
import { inject, observer } from "mobx-react";
import Button from "@material-ui/core/Button";
import TextField from "@material-ui/core/TextField";
import AccountCircleIcon from "@material-ui/icons/AccountCircle";
import { resend, verify } from "./verify-screen-logic";
import { useHistory } from "react-router-dom";

function VerifyScreen({ userStore }) {
  const history = useHistory();

  useEffect(() => {
    alert("Hemos enviado un código de verificación a tu correo");
  }, []);

  return (
    <div id="VerifyScreen">
      <div className="izqVerify">
        <h1 className="labelVerify">Verificar</h1>
        <AccountCircleIcon className="avatar" style={{ fontSize: 180 }} />

        <div className="form">
          <p className="mensaje">
            Acabamos de enviar un código de verificación al correo registrado{" "}
          </p>

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

          <br />
          <br />

          <Button
            type="submit"
            fullWidth
            variant="contained"
            color="primary"
            className="submit"
            onClick={() => verify(history)}
          >
            Verificar
          </Button>

          <br />
          <br />

          <Button
            type="submit"
            fullWidth
            variant="contained"
            color="tertiary"
            className="submit"
            onClick={() => resend()}
          >
            Enviar nuevo código
          </Button>
        </div>
      </div>

      <div className="derVerify">
        <h1 style={{ fontSize: "100px" }}>EasyParts</h1>
      </div>
    </div>
  );
}

export default inject("userStore")(observer(VerifyScreen));
