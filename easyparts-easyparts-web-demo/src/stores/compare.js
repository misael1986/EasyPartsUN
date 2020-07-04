import { decorate, observable } from "mobx";

class Compare {
  constructor() {
    this.parts = [];
  }
}

decorate(Compare, {
  parts: observable,
});

export default new Compare();
