export function closeSession(userStore, history) {
  userStore.clear();
  history.push("/");

  setTimeout(() => {
    alert("Has cerrado sesión de forma exitosa");
  }, 200);
}
