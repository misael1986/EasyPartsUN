import React from "react";
import "./login-screen.css";
import { signUp } from "./login-screen-logic";
import { inject, observer } from "mobx-react";
import Button from "@material-ui/core/Button";
import TextField from "@material-ui/core/TextField";
import FormControlLabel from "@material-ui/core/FormControlLabel";
import Checkbox from "@material-ui/core/Checkbox";
import Grid from "@material-ui/core/Grid";
import { Link, useHistory } from "react-router-dom";
import AccountCircleIcon from "@material-ui/icons/AccountCircle";

function Landing({ userStore }) {
  const history = useHistory();

  return (
    <div id="loginScreen">
      <div className="izqLogin">
        <h1 style={{ fontSize: "100px" }}>EasyParts</h1>
      </div>

      <div className="derLogin">
        <h1 className="labelIniciarSesion">Iniciar Sesión</h1>
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
          <FormControlLabel
            className="rememberMe"
            control={<Checkbox value="remember" color="primary" />}
            label="Recuerdame"
          />
          <Button
            type="submit"
            fullWidth
            variant="contained"
            color="primary"
            className="submit"
            onClick={() => signUp(history)}
          >
            Iniciar Sesión
          </Button>
          <br />
          <br />
          <Grid container>
            <Grid item xs>
              <Link to="/forgot" variant="body2">
                ¿Olvidaste tu contraseña?
              </Link>
            </Grid>
            <Grid item>
              <Link to="/signup" variant="body2">
                Registrate en EasyParts
              </Link>
            </Grid>
          </Grid>
        </div>
      </div>
    </div>
  );
}

export default inject("userStore")(observer(Landing));
