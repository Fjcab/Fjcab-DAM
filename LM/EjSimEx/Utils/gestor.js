let tweet = document.querySelector("#tweet");
let boton = document.querySelector("#boton");
let contenido = document.querySelector("#contenido");

boton.addEventListener("click", () => {
  contenido.innerHTML = `<div class="card" style="width: 18rem;">
    <img src="utils/descarga.jpg" class="card-img-top" alt="...">
    <div class="card-body">
      <p class="card-text">${tweet.value}</p>
    </div>
  </div>`;
});
