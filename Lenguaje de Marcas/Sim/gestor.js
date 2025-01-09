let nombre = document.querySelector("#nombre");
let email = document.querySelector("#email");
let telefono = document.querySelector("#telefono");
let web = document.querySelector("#web");
let asunto = document.querySelector("#asunto");
let comentario = document.querySelector("#comentario");
let boton = document.querySelector("#enviar");
let contenido = document.querySelector("#contenido");

boton.addEventListener("click", () => {
  if (
    nombre.value.length == 0 ||
    email.value.length == 0 ||
    asunto.value.length == 0 ||
    comentario.value.length == 0
  ) {
    alert("Faltan datos");
  } else {
    contenido.innerHTML = `
        <p>>Nombre: ${nombre.value}</p>
        <p>>Email: ${email.value}</p>
        <p>>Teléfono: ${telefono.value}</p>
        <p>>web: ${web.value}</p>
        <p>>Asunto: ${asunto.value}</p>
        <p>>Comentario: ${comentario.value}</p>
        `;
  }
});
