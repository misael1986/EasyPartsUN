import React from "react";
import "./compra.css";
import { useHistory } from "react-router-dom";
import TextField from "@material-ui/core/TextField";
import { buyPc } from "../../screens/final-screen/final-screen-logic";
import Button from "@material-ui/core/Button";

const Compra = ({ setCompra }) => {
  const history = useHistory();

  return (
    <div className="compra">
      <div className="formCompra">
        <TextField
          variant="outlined"
          margin="normal"
          required
          fullWidth
          id="nombre"
          label="Nombre completo"
          name="nombre"
          autoComplete="Nombre completo"
          autoFocus
        />
        <TextField
          variant="outlined"
          margin="normal"
          required
          fullWidth
          id="ciudad"
          label="Ciudad"
          name="ciudad"
          autoComplete="Ciudad"
          autoFocus
        />
        <TextField
          variant="outlined"
          margin="normal"
          required
          fullWidth
          id="direccion"
          label="Direccion"
          name="direccion"
          autoComplete="Direccion"
          autoFocus
        />
        <TextField
          variant="outlined"
          margin="normal"
          required
          fullWidth
          id="telefono"
          label="Telefono de contacto"
          name="telefono"
          autoComplete="Telefono"
          autoFocus
        />
        <p>
          *No te preocupes por el pago, podras hacerlo cuando recibas tu
          computador
        </p>
      </div>
      <div className="botones3">
        <Button
          type="submit"
          fullWidth
          variant="contained"
          color="primary"
          className="buttonOtro"
          onClick={() => buyPc(history)}
        >
          Finalizar
        </Button>
        <Button
          type="submit"
          fullWidth
          variant="contained"
          color="primary"
          className="button"
          onClick={() => setCompra(false)}
        >
          Cancelar
        </Button>
      </div>
    </div>
  );
};

export default Compra;
