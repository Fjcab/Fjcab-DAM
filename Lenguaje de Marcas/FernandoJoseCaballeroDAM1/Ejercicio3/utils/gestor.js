let nombre = document.querySelector("#nombre");
let apellido = document.querySelector("#apellido");
let correo = document.querySelector("#correo");
letcontraseña = document.querySelector("#contraseña");
let check = document.querySelector("#check");
let boton = document.querySelector("#boton");
let contenedor = document.querySelector("#contenedor");

boton.addEventListener("click", () => {
  if (check) {
    contenedor.innerHTML = `
        <div>
        <h5>${nombre.value} ${apellido.value}</h5>
        <div>
        <p>${contraseña.value}</p>
        </div>
        <div>
        <p>${correo.value}</p>
        </div>
        </div>`;
  } else {
    alert("marca la casilla de condiciones");
  }
});
