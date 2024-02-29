let inputNombre = document.querySelector("input#input-nombre");
let inputApellido = document.querySelector("input#input-apellido");
let inputCorreo = document.querySelector("input#input-correo");
let selectDepartamento = document.querySelector("select#select-departamento");
let boton = document.querySelector("#boton-agregar");
let listaUsuarios = document.querySelector("#lista-usuarios");
let listaUsuariosDatos = [];
let contador = document.querySelector("#contador");
let contadorIT = document.querySelector("#contadorIT");
let contadorMarketing = document.querySelector("#contadorMarketing");
let contadorVentas = document.querySelector("#contadorVentas");
let contadorAdministracion = document.querySelector("#contadorAdministracion");
let empleados = document.querySelector("#empleados");
boton.addEventListener("click", () => {
  if (
    inputNombre.value.length > 0 &&
    inputApellido.value.length > 0 &&
    inputCorreo.value.length > 0 &&
    selectDepartamento.value.length > 0
  ) {
    listaUsuariosDatos.push(
      `${inputNombre.value} ${inputApellido.value} ${inputCorreo.value} ${selectDepartamento.value}`
    );
    console.log(listaUsuariosDatos);
    let listaIT = listaUsuariosDatos.filter((item) => {
      return item.includes(" IT ");
    });
    if (listaIT.length > 0) {
      contadorIT.textContent = `nº de empleados en IT: ${listaIT.length}`;
    }
    let listaMarketing = listaUsuariosDatos.filter((item) => {
      return item.includes(" Marketing ");
    });
    if (listaMarketing.length > 0) {
      contadorMarketing.textContent = `Numero de empleados en Marketing: ${listaMarketing.length}`;
    }
    let listaVentas = listaUsuariosDatos.filter((item) => {
      return item.includes(" Ventas ");
    });
    if (listaVentas.length > 0) {
      contadorVentas.textContent = `Numero de empleados en Ventas: ${listaVentas.length}`;
    }
    let listaAdministracion = listaUsuariosDatos.filter((item) => {
      return item.includes(" Administracion ");
    });
    if (listaAdministracion.length > 0) {
      contadorAdministracion.textContent = `Numero de empleados en Administracion: ${listaAdministracion.length}`;
    }
    contador.textContent = `Numero total de empleados: ${listaUsuariosDatos.length}`;
    let nodo = document.createElement("li");
    nodo.textContent = `${inputNombre.value} ${inputApellido.value} ${inputCorreo.value} ${selectDepartamento.value}`;
    nodo.className = "animate__animated animate__slideInDown list-group-item";

    nodo.addEventListener("click", () => {
      nodo.classList.remove("animate__animated");
      nodo.classList.remove("animate__slideInDown");
      nodo.classList.add("animate__animated");
      nodo.classList.add("animate__rubberBand");
    });

    listaUsuarios.append(nodo);
    inputNombre.value = "";
    inputApellido.value = "";
    inputCorreo.value = "";
    selectDepartamento.value = "";
    Swal.fire({
      title: "¡¡¡Correcto!!!",
      text: "Usuario agregado correctamente",
      icon: "success",
      confirmButtonText: "OK",
      timer: 1500,
    });
  } else {
    Swal.fire({
      title: "¡¡¡Error!!!",
      text: "Faltan datos",
      icon: "error",
      confirmButtonText: "Error",
    });
  }
});
