import { computed, decorate, observable } from "mobx";

class User {
  constructor() {
    this.email = "";
    this.password = "";
    this.otp = "";
    this.loggedIn = false;

    this.pc = {
      chassis: null,
      cpu: null,
      gpu: null,
      motherboard: null,
      powerSource: null,
      ram: null,
      storage1: null,
      storage2: null,
    };

    this.quantities = {
      ram: 0,
      storage1: 0,
      storage2: 0,
      gpu: 0,
    };

    this.pc2 = {
      chassis: null,
      cpu: null,
      gpu: null,
      motherboard: null,
      powerSource: null,
      ram: null,
      storage1: null,
      storage2: null,
    };

    this.quantities2 = null;

    this.routeOrigin = "/";
  }

  setRamQuantity(increase) {
    if (increase && this.quantities.ram === 4) return;
    if (!increase && this.quantities.ram === 1) return;

    this.quantities = {
      ...this.quantities,
      ram: (this.quantities.ram = increase
        ? this.quantities.ram * 2
        : this.quantities.ram / 2),
    };
  }

  setStorageQuantity(id, increase) {
    const prev = this.quantities["storage" + id];
    if (increase && prev > 2) return;
    if (!increase && prev === 1) return;

    if (increase && this.pc["storage" + id].tecnologia === "M2") return;

    this.quantities = {
      ...this.quantities,
      ["storage" + id]: (this.quantities["storage" + id] += increase ? 1 : -1),
    };
  }

  get pcPower() {
    let total = 0;
    Object.keys(this.pc).forEach((it) => {
      if (this.pc[it] !== null && this.pc[it].potencia_max !== undefined) {
        total += this.pc[it].potencia_max;
      }
    });
    return total;
  }

  getPcPrice(pc, quantities) {
    let total = 0;
    Object.keys(pc).forEach((it) => {
      if (pc[it] !== null && pc[it].precio !== undefined) {
        if (quantities[pc[it].type] !== undefined) {
          total += pc[it].precio * quantities[pc[it].type];
        } else {
          total += pc[it].precio;
        }
      }
      //console.log(toJS(pc[it]));
      //console.log("New total with type: " + pc[it].type + " = " + total);
    });
    return total;
  }

  clear() {
    this.email = "";
    this.password = "";
    this.otp = "";
    this.loggedIn = false;

    this.clearPc();
    this.clearPc2();

    this.routeOrigin = "/";
  }

  clearPc() {
    this.pc = {
      chassis: null,
      cpu: null,
      gpu: null,
      motherboard: null,
      powerSource: null,
      ram: null,
      storage1: null,
      storage2: null,
    };

    this.quantities = {
      ram: 0,
      storage1: 0,
      storage2: 0,
      gpu: 0,
    };
  }

  clearPc2() {
    this.pc2 = {
      chassis: null,
      cpu: null,
      gpu: null,
      motherboard: null,
      powerSource: null,
      ram: null,
      storage1: null,
      storage2: null,
    };

    this.quantities2 = {
      ram: 0,
      storage1: 0,
      storage2: 0,
      gpu: 0,
    };
  }
}

decorate(User, {
  email: observable,
  password: observable,
  otp: observable,
  loggedIn: observable,

  pc: observable,
  pcPower: computed,

  quantities: observable,
});

export default new User();
