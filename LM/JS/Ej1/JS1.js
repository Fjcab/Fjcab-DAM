//Ejercicio 1----------------------------------------------------------------------------------------------

let numero = document.querySelector("#numero");
let boton = document.querySelector("#boton");
/*if (numero.value % 2 == 0) {
  console.log("el número es par");
} else {
  console.log("el número es impar");
}*/

boton.addEventListener("click", () => {
  if (numero.value.length > 0) {
    if (numero.value % 2 == 0) {
      console.log("el número es par");
      Swal.fire({
        title: "¡¡¡PAR!!!",
        text: "El número es Par",
        icon: "success",
        confirmButtonText: "OK",
        timer: 2000,
      });
    } else {
      console.log("el número es impar");
      Swal.fire({
        title: "¡¡¡IMPAR!!!",
        text: "El número es Impar",
        icon: "success",
        confirmButtonText: "OK",
        timer: 2000,
      });
    }
    numero.value = "";
  } else {
    Swal.fire({
      title: "¡¡¡Error!!!",
      text: "Faltan datos",
      icon: "error",
      confirmButtonText: "Error",
    });
  }
});

//Ejercicio 2---------------------------------------------------------------------------------------------

/*
let listanumeros = [
  1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20,
];
listanumeros.forEach((numero) => {
  if (numero % 2 == 0) {
    console.log(`el número ${numero} es par`);
  } else {
    console.log(`el número ${numero} es impar`);
  }
});
*/

//Ejercicio 3-----------------------------------------------------------------------------------------------

let texto = document.querySelector("#texto");
let boton1 = document.querySelector("#boton1");

boton1.addEventListener("click", () => {
  if (texto.value.length > 0) {
    if (texto.value == texto.value.toUpperCase()) {
      console.log("el texto está en mayusculas");
      Swal.fire({
        title: "¡¡¡MAYUSCULAS!!!",
        text: "EL TEXTO ESTA EN MAYUSCULAS",
        icon: "success",
        confirmButtonText: "OK",
        timer: 2000,
      });
    } else {
      if (texto.value == texto.value.toLowerCase()) {
        console.log("el texto está en minusculas");
        Swal.fire({
          title: "¡¡¡minusculas!!!",
          text: "el texto está en minusculas",
          icon: "success",
          confirmButtonText: "OK",
          timer: 2000,
        });
      } else {
        console.log("el texto está en MAYUSCULAS y minusculas");
        Swal.fire({
          title: "¡¡¡ERROR!!!",
          text: "el texto está en MAYUSCULAS y minusculas",
          icon: "error",
          confirmButtonText: "OK",
          timer: 2000,
        });
      }
    }
    texto.value = "";
  } else {
    Swal.fire({
      title: "¡¡¡Error!!!",
      text: "Faltan datos",
      icon: "error",
      confirmButtonText: "Error",
    });
  }
});

//Ejercicio 4----------------------------------------------------------------------------------------------

let texto1 = document.querySelector("#texto1");
let boton2 = document.querySelector("#boton2");

boton2.addEventListener("click", () => {
  if (texto1.value.length > 0) {
    texto1.value = texto1.value.replaceAll(" ", "/");
  }
});

//Ejercicio 5----------------------------------------------------------------------------------------------

let listanum = [];
let pnumaleatorio = document.querySelector("#numaleatorio");

for (let i = 0; i < 10; i++) {
  listanum.push(Math.floor(Math.random() * 50) + 1);
}
let listamayor = listanum.filter((item) => {
  return item > 25;
});

console.log(listanum);
let nodo = document.createElement("p");
nodo.textContent = listanum;
nodo.id = "lista_aleatorio";
pnumaleatorio.append(nodo);

console.log(listamayor);
let nodo1 = document.createElement("p");
nodo1.textContent = listamayor;
nodo1.id = "lista_mayor";
pnumaleatorio.append(nodo1);
