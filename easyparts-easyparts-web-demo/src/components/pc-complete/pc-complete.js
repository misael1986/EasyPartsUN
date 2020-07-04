import React, { Fragment, useState } from "react";
import "./pc-complete.css";
import { Compra, PcCompare } from "../index";
import { useHistory } from "react-router-dom";
import { SearchStore, UserStore } from "../../stores";
import Button from "@material-ui/core/Button";

const PcComplete = ({ pc }) => {
  const history = useHistory();

  const formato = new Intl.NumberFormat("es-CO", {
    style: "currency",
    currency: "COP",
    minimumFractionDigits: 0,
  });

  const [compra, setCompra] = useState(false);

  function buy() {
    if (!UserStore.loggedIn) {
      alert("Por favor loguéate con tu usuario para finalizar tu compra");
      UserStore.routeOrigin = "/final";
      history.push("/login");
    } else {
      setCompra(!compra);
    }
  }

  return (
    <Fragment>
      {UserStore.pc2.cpu == null && (
        <div className="computador">
          <div className="lista">
            <img className="FinalImage" src={pc.cpu.imagen} alt="Img" />
            <p>{pc.cpu.nombre}</p>
            <p>{"Numero de nucleos: " + pc.cpu.num_nucleos}</p>
            <p>{"Frecuencia: " + pc.cpu.frecuencia}</p>
            <p>{"Cache: " + pc.cpu.pcache}</p>
            <p>{"Grafica integrada: " + pc.cpu.grafica_integrada}</p>
            <p>{"Sockte: " + pc.cpu.psocket}</p>
            <p>{"Potencia maxima: " + pc.cpu.potencia_max}</p>
          </div>
          <div className="lista">
            <img className="FinalImage" src={pc.ram.imagen} alt="Img" />
            <p>{pc.ram.nombre}</p>
            <p>{"Capacidad: " + pc.ram.capacidad}</p>
            <p>{"Velocidad: " + pc.ram.velocidad}</p>
            <p>{"Teconologia: " + pc.ram.tecnologia}</p>
            <p>{"Potencia maxima: " + pc.ram.potencia_max}</p>
          </div>
          <div className="lista">
            <img className="FinalImage" src={pc.storage1.imagen} alt="Img" />
            <p>{pc.storage1.nombre}</p>
            <p>{"Capacidad: " + pc.storage1.capacidad}</p>
            <p>{"Tecnologia: " + pc.storage1.tecnologia}</p>
            <p>{"Puerto: " + pc.storage1.puerto}</p>
            <p>{"Velocidad de lectura: " + pc.storage1.velocidad_lectura}</p>
            <p>
              {"Velocidad de escritura: " + pc.storage1.velocidad_escritura}
            </p>
            <p>{"Potencia maxima: " + pc.storage1.potencia_max}</p>
          </div>
          {pc.storage2 !== null && pc.storage2 !== undefined && (
            <div className="lista">
              <img className="FinalImage" src={pc.storage2.imagen} alt="Img" />
              <p>{pc.storage2.nombre}</p>
              <p>{"Capacidad: " + pc.storage2.capacidad}</p>
              <p>{"Tecnologia: " + pc.storage2.tecnologia}</p>
              <p>{"Puerto: " + pc.storage2.puerto}</p>
              <p>{"Velocidad de lectura: " + pc.storage2.velocidad_lectura}</p>
              <p>
                {"Velocidad de escritura: " + pc.storage2.velocidad_escritura}
              </p>
              <p>{"Potencia maxima: " + pc.storage2.potencia_max}</p>
            </div>
          )}
          <div className="lista">
            <img className="FinalImage" src={pc.gpu.imagen} alt="Img" />
            <p>{pc.gpu.nombre}</p>
            <p>{"Pci express: " + pc.gpu.pci_express}</p>
            <p>
              {"Memoria: " + pc.gpu.tipo_memoria + pc.gpu.capacidad_memoria}
            </p>
            <p>{"Proposito: " + pc.gpu.proposito}</p>
            <p>{"Potencia maxima: " + pc.gpu.potencia_max}</p>
          </div>
          <div className="lista">
            <img className="FinalImage" src={pc.motherboard.imagen} alt="Img" />
            <p>{pc.motherboard.nombre}</p>
            <p>{"Categoria: " + pc.motherboard.categoria}</p>
            <p>{"Socket: " + pc.motherboard.msocket}</p>
            <p>{"Bios: " + pc.motherboard.bios}</p>
            <p>
              {"Slot RAM: " +
                pc.motherboard.slot_ram +
                " (x" +
                pc.motherboard.ram_cantidad +
                ")"}
            </p>
            <p>
              {"Slot GPU: " +
                pc.motherboard.slot_gpu +
                " (x" +
                pc.motherboard.gpu_cantidad +
                ")"}
            </p>
            <p>
              {"Tipo de Sata: " +
                pc.motherboard.tipo_sata +
                " (x" +
                pc.motherboard.cantidad_sata +
                ")"}
            </p>
            <p>{"MDOS: " + pc.motherboard.mdos_cantidad}</p>
          </div>
          <div className="lista">
            <img className="FinalImage" src={pc.powerSource.imagen} alt="Img" />
            <p>{pc.powerSource.nombre}</p>
            <p>{"Potencia: " + pc.powerSource.potencia}</p>
            <p>{"Certificacion: " + pc.powerSource.certificacion}</p>
          </div>
          <div className="lista">
            <img className="FinalImage" src={pc.chassis.imagen} alt="Img" />
            <p>{pc.chassis.nombre}</p>
            <p>{"Motherboards: " + pc.chassis.motherboards}</p>
            <p>
              {"Medidas: " +
                pc.chassis.alto +
                "x" +
                pc.chassis.largo +
                "x" +
                pc.chassis.ancho +
                " (alto X largo X ancho"}
            </p>
          </div>
        </div>
      )}

      {UserStore.pc2.cpu !== null ? <PcCompare setCompra={setCompra} /> : null}

      {UserStore.pc2.cpu == null && (
        <div className="botones">
          <Button
            type="submit"
            fullWidth
            variant="contained"
            color="primary"
            className="buttonOtro"
            onClick={() => {
              SearchStore.clear();
              history.push("/");
              alert(
                "Este computador ha sido guardado en tu cuenta. Recuerda que solo se guardaran los dos ultimos que escogas."
              );
            }}
          >
            Escoger otro
          </Button>
          <Button
            type="submit"
            fullWidth
            variant="contained"
            color="primary"
            className="button"
            onClick={buy}
          >
            Finalizar compra{" "}
            {formato.format(
              UserStore.getPcPrice(UserStore.pc, UserStore.quantities)
            )}
          </Button>
        </div>
      )}
      {compra ? <Compra setCompra={setCompra} /> : null}
    </Fragment>
  );
};

export default PcComplete;
