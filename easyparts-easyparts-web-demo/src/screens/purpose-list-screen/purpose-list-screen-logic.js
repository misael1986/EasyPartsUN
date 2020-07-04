import api from "../../axios/api";
import { PurposeStore, UserStore } from "../../stores";

function getTowersWithPurpose() {
  api.tower.purpose(PurposeStore.name).then((success) => {
    const promises = success.data.map((it) => api.tower.find(it.id));

    Promise.all(promises).then((done) => {
      PurposeStore.list = [...done]
        .map((it) => it.data)
        .sort((a, b) => a.preciototal - b.preciototal);
    });
  });
}

function choosePc(tower) {
  UserStore.pc.chassis = tower.gabinete;
  UserStore.pc.powerSource = tower.powerSource;
  UserStore.pc.cpu = tower.procesador;
  UserStore.pc.gpu = tower.tarjetaVideo;
  UserStore.pc.motherboard = tower.board;
  UserStore.pc.ram = tower.ram;
  UserStore.pc.storage1 = tower.discos[0];
  if (tower.discos.length > 1) {
    UserStore.pc.storage2 = tower.discos[1];
  }

  UserStore.quantities.ram = tower.cant_ram;
  UserStore.quantities.gpu = tower.cant_grafica;
  UserStore.quantities.storage1 = tower.cant_discos[0];
  if (tower.cant_discos.length > 1) {
    UserStore.quantities.storage2 = tower.cant_discos[1];
  }

  UserStore.pc.chassis.type = "chassis";
  UserStore.pc.powerSource.type = "powerSource";
  UserStore.pc.cpu.type = "cpu";
  UserStore.pc.gpu.type = "gpu";
  UserStore.pc.motherboard.type = "motherboard";
  UserStore.pc.ram.type = "ram";
  UserStore.pc.storage1.type = "storage1";
  if (tower.discos.length > 1) {
    UserStore.pc.storage2.type = "storage2";
  }
}

export { getTowersWithPurpose, choosePc };
