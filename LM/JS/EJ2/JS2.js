//Ejercicio 1 ----------------------------------------------------------------------------------------------

let numero = document.querySelector("#numero");
let boton = document.querySelector("#boton");
let noprimo = 0;

boton.addEventListener("click", () => {
  if (numero.value.length > 0) {
    if (numero.value <= 0) {
      console.log("Error introduce un numero positivo");
      Swal.fire({
        title: "¡¡¡Error!!!",
        text: "Error introduce un numero positivo",
        icon: "error",
        confirmButtonText: "Error",
      });
    } else {
      if (numero.value > 2) {
        for (let i = 2; i < numero.value; i++) {
          if (numero.value % i == 0) {
            noprimo = numero.value;
            break;
          }
        }
      }
      if ((numero.value == 1) | (noprimo == numero.value)) {
        console.log(`${numero.value} no es primo`);
        Swal.fire({
          title: "¡¡¡NO PRIMO!!!",
          text: `${numero.value} no es primo`,
          icon: "success",
          confirmButtonText: "OK",
          timer: 2000,
        });
      } else {
        console.log(`${numero.value} es primo`);
        Swal.fire({
          title: "¡¡¡PRIMO!!!",
          text: `${numero.value} es primo`,
          icon: "success",
          confirmButtonText: "OK",
          timer: 2000,
        });
      }
    }
  } else {
    Swal.fire({
      title: "¡¡¡Error!!!",
      text: "Faltan datos",
      icon: "error",
      confirmButtonText: "Error",
    });
  }
  numero.value = "";
});

//Ejercicio 2 ----------------------------------------------------------------------------------------------

let celsius = document.querySelector("#celsius");
let botoncomprobar = document.querySelector("#boton-comprobar");
let botonborrar = document.querySelector("#boton-borrar");
let resultado = document.querySelector("#resultado");

botoncomprobar.addEventListener("click", () => {
  let fahrenheit = celsius.value * 1.8 + 32;
  resultado.textContent = `${celsius.value}º Celsius es igual a ${fahrenheit}º fahrenheit.`;
});

botonborrar.addEventListener("click", () => {
  celsius.value = "";
  resultado.textContent = "";
});

//Ejercicio 3 ----------------------------------------------------------------------------------------------

let rojo = document.querySelector("#boton-rojo");
let azul = document.querySelector("#boton-azul");
let amarillo = document.querySelector("#boton-amarillo");
let negro = document.querySelector("#boton-negro");
let blanco = document.querySelector("#boton-blanco");
let cuerpo = document.querySelector("#cuerpo");

rojo.addEventListener("click", () => {
  cuerpo.style = "background-color: red; color: black";
});
azul.addEventListener("click", () => {
  cuerpo.style = "background-color: blue; color: white";
});
amarillo.addEventListener("click", () => {
  cuerpo.style = "background-color: yellow; color: black";
});
negro.addEventListener("click", () => {
  cuerpo.style = "background-color: black; color: white";
});
blanco.addEventListener("click", () => {
  cuerpo.style = "background-color: white; color:black";
});

//Ejercicio 4 ----------------------------------------------------------------------------------------------

let nombre = document.querySelector("#nombre");
let apellido = document.querySelector("#apellido");
let localidad = document.querySelector("#localidad");
let fecha = document.querySelector("#fecha");
let edad1 = document.querySelector("#edad1");
let edad2 = document.querySelector("#edad2");
let correo = document.querySelector("#correo");
let info = document.querySelector("#info");
let reset = document.querySelector("#reset");
let modaltitle = document.querySelector("#modal-title");
let modalbody = document.querySelector("#modal-body");

info.addEventListener("click", () => {
  modaltitle.innerHTML = `${nombre.value} ${apellido.value}`;
  modalbody.innerHTML = `
  <p>Localidad: ${localidad.value}</p>
  <p>Fecha de nacimiento: ${fecha.value}</p>
  <p>Edad: ${edad1.value}${edad2.value}</p>
  <p>Correo: ${correo.value}</p>`;
});

reset.addEventListener("click", () => {
  nombre.value = "";
  apellido.value = "";
  localidad.value = "";
  fecha.value = "";
  edad1.value = "";
  edad2.value = "";
  correo.value = "";
});

//Ejercicio 5 ----------------------------------------------------------------------------------------------

let nombre1;
let edad;
let botonprompt = document.querySelector("#boton-prompt");
let modaltitle1 = document.querySelector("#modal-title");
let modalbody1 = document.querySelector("#modal-body");

function vida(edad) {
  diasextra = edad / 4;
  diasvida = edad * 365;
  return diasvida + parseInt(diasextra);
}

botonprompt.addEventListener("click", () => {
  do {
    nombre1 = prompt("¿Introduce tu nombre?");
  } while (nombre1.length == 0);
  do {
    edad = parseInt(prompt("Introduce tu edad"));
  } while (isNaN(edad) || edad < 0);
  console.log(nombre1);
  console.log(edad);
  console.log(vida(edad));
  modaltitle.innerHTML = `${nombre1}`;
  modalbody.innerHTML = `<p>Has vivido ${vida(edad)} dias.</p>`;
});
