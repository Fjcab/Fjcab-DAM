let valor1 = document.querySelector("#valor1");
let operacion = document.querySelector("#operacion");
let valor2 = document.querySelector("#valor2");
let resultado = document.querySelector("#resultado");
let boton = document.querySelector("#btn");
let valorResultado;

operacion.addEventListener("change", () => {
  if (valor1.value.length == 0) {
    valor1.value = 0;
  }
  if (valor2.value.length == 0) {
    valor2.value = 0;
  }
  if (operacion.value == "+") {
    console.log(
      (valorResultado = parseInt(valor1.value) + parseInt(valor2.value))
    );
    if (isNaN(valorResultado)) {
      resultado.innerHTML = `<p>${valor1.value}</p><p>+</p><p>${valor2.value}</p><p>=</p><p>Introduce valores válidos</p>`;
    } else {
      resultado.innerHTML = `<p>${valor1.value}</p><p>+</p><p>${valor2.value}</p><p>=</p><p>${valorResultado}</p>`;
      Swal.fire({
        title: `${valorResultado}`,
        text: `${valor1.value} + ${valor2.value}`,
        icon: "success",
      });
    }
    operacion.value = 0;
  }
  if (operacion.value == "-") {
    console.log(
      (valorResultado = parseInt(valor1.value) - parseInt(valor2.value))
    );
    if (isNaN(valorResultado)) {
      resultado.innerHTML = `<p>${valor1.value}</p><p>-</p><p>${valor2.value}</p><p>=</p><p>Introduce valores válidos</p>`;
    } else {
      resultado.innerHTML = `<p>${valor1.value}</p><p>-</p><p>${valor2.value}</p><p>=</p><p>${valorResultado}</p>`;
      Swal.fire({
        title: `${valorResultado}`,
        text: `${valor1.value} - ${valor2.value}`,
        icon: "success",
      });
    }
    operacion.value = 0;
  }
  if (operacion.value == "*") {
    console.log(
      (valorResultado = parseInt(valor1.value) * parseInt(valor2.value))
    );
    if (isNaN(valorResultado)) {
      resultado.innerHTML = `<p>${valor1.value}</p><p>x</p><p>${valor2.value}</p><p>=</p><p>Introduce valores válidos</p>`;
    } else {
      resultado.innerHTML = `<p>${valor1.value}</p><p>x</p><p>${valor2.value}</p><p>=</p><p>${valorResultado}</p>`;
      Swal.fire({
        title: `${valorResultado}`,
        text: `${valor1.value} X ${valor2.value}`,
        icon: "success",
      });
    }
    operacion.value = 0;
  }
  if (operacion.value == "/") {
    console.log(
      (valorResultado = parseInt(valor1.value) / parseInt(valor2.value))
    );
    if (isNaN(valorResultado)) {
      resultado.innerHTML = `<p>${valor1.value}</p><p>/</p><p>${valor2.value}</p><p>=</p><p>Introduce valores válidos</p>`;
    } else {
      resultado.innerHTML = `<p>${valor1.value}</p><p>/</p><p>${valor2.value}</p><p>=</p><p>${valorResultado}</p>`;
      Swal.fire({
        title: `${valorResultado}`,
        text: `${valor1.value} / ${valor2.value}`,
        icon: "success",
      });
    }
    operacion.value = 0;
  }
  if (operacion.value == "%") {
    console.log(
      (valorResultado = parseInt(valor1.value) % parseInt(valor2.value))
    );
    if (isNaN(valorResultado)) {
      resultado.innerHTML = `<p>${valor1.value}</p><p>resto</p><p>${valor2.value}</p><p>=</p><p>Introduce valores válidos</p>`;
    } else {
      resultado.innerHTML = `<p>${valor1.value}</p><p>resto</p><p>${valor2.value}</p><p>=</p><p>${valorResultado}</p>`;
      Swal.fire({
        title: `${valorResultado}`,
        text: `${valor1.value} resto de ${valor2.value}`,
        icon: "success",
      });
    }
    operacion.value = 0;
  }
});

boton.addEventListener("click", () => {
  valor1.value = "";
  valor2.value = "";
  resultado.innerHTML = `<p>valor 1</p>
  <p>Operación</p>
  <p>valor2</p>
  <p>=</p>
  <p>resultado</p>
  `;
  operacion.value = 0;
  Swal.fire({
    title: "Reset",
    text: "¡Borrado!",
    icon: "info",
    timer: 2000,
  });
});
