import { SearchStore, UserStore } from "../../stores";

export function buyPc(history) {
  SearchStore.clear();
  UserStore.clear();
  alert("Tu computador llegará de 2 a 5 días hábiles.");
  history.push("/");
}
