import React from "react";
import "./pc-compare.css";
import { useHistory } from "react-router-dom";
import Button from "@material-ui/core/Button";
import { SearchStore, UserStore } from "../../stores";

const PcCompare = ({ setCompra }) => {
  const history = useHistory();

  const pc1 = UserStore.pc;
  const pc2 = UserStore.pc2;
  const quantities1 = UserStore.quantities;
  const quantities2 = UserStore.quantities2;

  const formato = new Intl.NumberFormat("es-CO", {
    style: "currency",
    currency: "COP",
    minimumFractionDigits: 0,
  });


  function buy() {
    if (!UserStore.loggedIn) {
      alert("Por favor loguéate con tu usuario para finalizar tu compra");
      UserStore.routeOrigin = "/final";
      history.push("/login");
    } else {
      setCompra(true);
    }
  }

  return (
    <div className="comparar-visible">
      <div className="pcs">
        <div className="pc">
          <img
            className="FinalImageComparar"
            src={pc1.chassis.imagen}
            alt="Img"
          />
          <p className="componente">Gabinete</p>
          <p>{pc1.chassis.nombre}</p>
          <p className="componente">Motherboard</p>
          <p>
            {pc1.motherboard.nombre} de categoria {pc1.motherboard.categoria}{" "}
            con {pc1.motherboard.ram_cantidad} slots para ram,{" "}
            {pc1.motherboard.gpu_cantidad} slost para gpu,{" "}
            {pc1.motherboard.cantidad_sata} conexiones sata
          </p>
          <p className="componente">Procesador</p>
          <p>
            {pc1.cpu.nombre} con {pc1.cpu.num_nucleos} nucleos y velocidad de{" "}
            {pc1.cpu.frecuencia}GHz
          </p>
          <p className="componente">Ram</p>
          <p>
            4 {pc1.ram.nombre} {pc1.ram.tecnologia} de {pc1.ram.capacidad} con{" "}
            {pc1.ram.velocidad} de velocidad
          </p>
          <p className="componente">Tarjeta de video</p>
          <p>
            {pc1.gpu.nombre} con capacidad de {pc1.gpu.capacidad_memoria}GB de
            memoria ram {pc1.gpu.tipo_memoria}
          </p>
          <p className="componente">Almacenamiento</p>
          <p>
            1 {pc1.storage1.marca} {pc1.storage1.modelo}{" "}
            {pc1.storage1.tecnologia} {pc1.storage1.puerto} de{" "}
            {pc1.storage1.capacidad} y {pc1.storage1.velocidad_lectura}/
            {pc1.storage1.velocidad_escritura} velocidad de lectura/escritura
          </p>
          <p className="componente">Almacenamiento</p>
          <p>
            1 {pc1.storage2.marca} {pc1.storage2.modelo}{" "}
            {pc1.storage2.tecnologia} {pc1.storage2.puerto} de{" "}
            {pc1.storage2.capacidad} y {pc1.storage2.velocidad_lectura}/
            {pc1.storage2.velocidad_escritura} velocidad de lectura/escritura
          </p>
          <p className="componente">Fuente de poder</p>
          <p>
            {pc1.powerSource.nombre} con {pc1.powerSource.potencia}W de potencia
          </p>
        </div>
        <div className="pc">
          <img
            className="FinalImageComparar"
            src={pc2.chassis.imagen}
            alt="Img"
          />
          <p className="componente">Gabinete</p>
          <p>{pc2.chassis.nombre}</p>
          <p className="componente">Motherboard</p>
          <p>
            {pc2.motherboard.nombre} de categoria {pc2.motherboard.categoria}{" "}
            con {pc2.motherboard.ram_cantidad} slots para ram,{" "}
            {pc2.motherboard.gpu_cantidad} slost para gpu,{" "}
            {pc2.motherboard.cantidad_sata} conexiones sata
          </p>
          <p className="componente">Procesador</p>
          <p>
            {pc2.cpu.nombre} con {pc2.cpu.num_nucleos} nucleos y velocidad de{" "}
            {pc2.cpu.frecuencia}GHz
          </p>
          <p className="componente">Ram</p>
          <p>
            4 {pc2.ram.nombre} {pc2.ram.tecnologia} de {pc2.ram.capacidad} con{" "}
            {pc2.ram.velocidad} de velocidad
          </p>
          <p className="componente">Tarjeta de video</p>
          <p>
            {pc2.gpu.nombre} con capacidad de {pc2.gpu.capacidad_memoria}GB de
            memoria ram {pc2.gpu.tipo_memoria}
          </p>
          <p className="componente">Almacenamiento</p>
          <p>
            1 {pc2.storage1.marca} {pc2.storage1.modelo}{" "}
            {pc2.storage1.tecnologia} {pc2.storage1.puerto} de{" "}
            {pc2.storage1.capacidad} y {pc2.storage1.velocidad_lectura}/
            {pc2.storage1.velocidad_escritura} velocidad de lectura/escritura
          </p>
          <p className="componente">Almacenamiento</p>
          <p>
            1 {pc2.storage2.marca} {pc2.storage2.modelo}{" "}
            {pc2.storage2.tecnologia} {pc2.storage2.puerto} de{" "}
            {pc2.storage2.capacidad} y {pc2.storage2.velocidad_lectura}/
            {pc2.storage2.velocidad_escritura} velocidad de lectura/escritura
          </p>
          <p className="componente">Fuente de poder</p>
          <p>
            {pc2.powerSource.nombre} con {pc2.powerSource.potencia}W de potencia
          </p>
        </div>
      </div>
      <div className="botones1">
          <Button
            type="submit"
            fullWidth
            variant="contained"
            color="primary"
            className="button"
            onClick={buy}
          >
            Comprar {formato.format(UserStore.getPcPrice(pc1, quantities1))}
          </Button>
          <Button
            type="submit"
            fullWidth
            variant="contained"
            color="primary"
            className="button"
            onClick={buy}
          >
            Comprar {formato.format(UserStore.getPcPrice(pc2, quantities2))}
          </Button>
      </div>
      <div className="botones2">
          <Button
            type="submit"
            fullWidth
            variant="contained"
            color="primary"
            className="button"
            onClick={() => {
              SearchStore.clear();
              history.push("/");
              alert(
                "Tu segundo computador ha sido guardado en tu cuenta. Recuerda que solo se guardaran los dos ultimos que escogas."
              );
            }}
          >
            Escoger otro
          </Button>
      </div>
    </div>
  );
};

export default PcCompare;
