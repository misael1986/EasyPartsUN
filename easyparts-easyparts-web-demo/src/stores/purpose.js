import { decorate, observable } from "mobx";

class Purpose {
  constructor() {
    this.name = null;
    this.list = [];
  }
}

decorate(Purpose, {
  name: observable,
  list: observable,
});

export default new Purpose();
