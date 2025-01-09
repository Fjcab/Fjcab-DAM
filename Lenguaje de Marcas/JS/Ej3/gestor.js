//Ejercicio 1

let inputNombre = document.querySelector("#inputNombre");
let nombre = document.querySelector("#nombre");
let inputApellido = document.querySelector("#inputApellido");
let apellido = document.querySelector("#apellido");
let inputEmail = document.querySelector("#inputEmail");
let email = document.querySelector("#email");
let inputPassword = document.querySelector("#inputPassword");
let password = document.querySelector("#password");
let texto = document.querySelector("#texto");
let comentario = document.querySelector("#comentario");
let condiciones = document.querySelector("#check");
let acepto = document.querySelector("#acepto");
let boton = document.querySelector("#btn");
let reset = document.querySelector("#reset");

boton.addEventListener("click", () => {
  clicks(
    inputNombre,
    inputApellido,
    inputEmail,
    inputPassword,
    texto,
    condiciones
  );
});

function clicks(
  inputNombre,
  inputApellido,
  inputEmail,
  inputPassword,
  texto,
  condiciones
) {
  nombres(inputNombre);
  apellidos(inputApellido);
  emails(inputEmail);
  passwords(inputPassword);
  textos(texto);
  cheks(condiciones);
}

function reseteo() {
  inputNombre.value = "";
  inputApellido.value = "";
  inputEmail.value = "";
  inputPassword.value = "";
  texto.value = "";
  condiciones.checked = false;
  nombre.innerHTML = ``;
  apellido.innerHTML = ``;
  email.innerHTML = ``;
  password.innerHTML = ``;
  comentario.innerHTML = ``;
  acepto.innerHTML = ``;
  Swal.fire({
    icon: "info",
    title: "Reset",
    text: "¡Campos eliminados",
  });
}

function nombres(inputNombre) {
  if (!contenido(inputNombre)) {
    nombre.innerHTML = `<p>Nombre es un campo obligatorio</p>`;
    Swal.fire({
      icon: "error",
      title: "Nombre",
      text: "¡Nombre es un campo obligatorio!",
    });
  } else {
    nombre.innerHTML = `<b>${inputNombre.value}</b>`;
  }
}

function apellidos(inputApellido) {
  apellido.innerHTML = `<b>${inputApellido.value}</b>`;
}

function emails(inputEmail) {
  if (!contenido(inputEmail)) {
    Swal.fire({
      icon: "error",
      title: "Email",
      text: "¡Email es un campo obligatorio!",
    });
    email.innerHTML = `<p>Email es un campo obligatorio</p>`;
  } else {
    if (correo(inputEmail)) {
      email.innerHTML = `<b>${inputEmail.value}</b>`;
    } else {
      Swal.fire({
        icon: "warning",
        title: "Email",
        text: "¡Email debe incluir @!",
      });
      email.innerHTML = `<p>Email debe incluir @</p>`;
    }
  }
}

function passwords(inputPassword) {
  if (!contenido(inputPassword)) {
    Swal.fire({
      icon: "error",
      title: "Password",
      text: "¡Password es un campo obligatorio!",
    });
    password.innerHTML = `<p>Password es un campo obligatorio</p>`;
  } else {
    if (contraseña(inputPassword)) {
      Swal.fire({
        icon: "warning",
        title: "Password",
        text: "¡Password debe tener un minimo de 6 caracteres!",
      });
      password.innerHTML = `<p>Password debe tener un minimo de 6 caracteres</p>`;
    } else {
      password.innerHTML = `<b>Password válida</b>`;
    }
  }
}

function textos(texto) {
  if (!contenido(texto)) {
    Swal.fire({
      icon: "error",
      title: "Comentarios",
      text: "¡Comentarios es un campo obligatorio!",
    });
    comentario.innerHTML = `<p>Comentarios es un campo obligatorio</p>`;
  } else {
    comentario.innerHTML = `<b>${texto.value}</b>`;
  }
}

function cheks(condiciones) {
  if (!check(condiciones)) {
    Swal.fire({
      icon: "question",
      title: "Condiciones",
      text: "¡Tienes que aceptar las condiciones del servicio!",
    });
    acepto.innerHTML = `<p>Tienes que aceptar las condiciones del servicio</p>`;
  } else {
    acepto.innerHTML = `<b>Acepto las condiciones del servicio.</b>`;
  }
}

function contenido(contenido) {
  if (contenido.value.length != 0) {
    return true;
  }
}

function correo(correo) {
  if (correo.value.includes("@")) {
    return true;
  }
}

function contraseña(contraseña) {
  if (contraseña.value.length < 6) {
    return true;
  }
}

function check(marca) {
  if (marca.checked) {
    return true;
  }
}
//Ejercicio 2
let input = document.querySelector("#input");
let input2 = document.querySelector("#input2");
let input3 = document.querySelector("#input3");
let presionado = document.querySelector("#presionado");
let levantado = document.querySelector("#levantado");
let color = document.querySelector("#color");

function presion() {
  presionado.innerHTML = `${input.value}`;
}

function levantar() {
  levantado.innerHTML = `${input2.value}`;
}

function foco(valor) {
  valor.value = "";
}
function alerta(valor) {
  console.log(valor.value);
  if (valor.value == "") {
    Swal.fire({
      icon: "question",
      title: "Datos",
      text: "¡Introduce datos!",
      timer: 2000,
    });
    valor.value = "focus-blur";
  }
}

function seleccionar() {
  color.style = "background-color: aqua;";
}

function seleccionar2() {
  color.style = "background-color: white;";
}
