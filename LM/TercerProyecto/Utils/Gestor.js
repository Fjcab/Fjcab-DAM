let productos = document.querySelector("#productos");
let categoria = document.querySelector("#categoria");
let marca = document.querySelector("#marca");
let InputPrecio = document.querySelector("#input-precio");
let btnMin = document.querySelector("#btn-min");
let carrito = document.querySelector("#carrito");
let btnBorrar = document.querySelector("#btn-borrar");
let cosa;
let array = [];

fetch("https://dummyjson.com/products")
  .then((result) => {
    return result.json();
  })
  .then((results2) => {
    results2.products.forEach((item) => {
      if (!categoria.innerHTML.includes(`${item.category}`)) {
        if (`${item.category}` == "smartphones") {
          categoria.innerHTML += `<option value="${item.category}">Smartphone</option>`;
        }
        if (`${item.category}` == "laptops") {
          categoria.innerHTML += `<option value="${item.category}">Portatiles</option>`;
        }
        if (`${item.category}` == "fragrances") {
          categoria.innerHTML += `<option value="${item.category}">Colonias</option>`;
        }
        if (`${item.category}` == "skincare") {
          categoria.innerHTML += `<option value="${item.category}">Cuidado de la piel</option>`;
        }
        if (`${item.category}` == "groceries") {
          categoria.innerHTML += `<option value="${item.category}">Alimentos</option>`;
        }
        if (`${item.category}` == "home-decoration") {
          categoria.innerHTML += `<option value="${item.category}">Hogar</option>`;
        }
      }
      if (!marca.innerHTML.includes(`${item.brand}`)) {
        marca.innerHTML += `<option value="${item.brand}">${item.brand}</option>`;
      }

      productos.innerHTML += `<div class="card text-center" style="width: 18rem; background-color: plum;">
        <div class="card-header m-2 bg-transparent border-success"><img src='${item.thumbnail}' class="card-img-top" alt="..."></div>
        <div class="card-body">
        <h5 class="card-title">${item.title}</h5>
        <p class="card-text">${item.description}</p>
        <p class="card-text">Evaluación: ${item.rating}</p>
        <p class="card-text">Stock: ${item.stock}unidades</p>
        <p class="card-text">Precio:${item.price}€</p>
        <p class="card-text">Descuento: ${item.discountPercentage}</p>
        </div>
        <div class="card-footer bg-transparent border-success">  
        <button onclick="comprar(${item.id})" class="btn btn-success">Comprar ${item.title}</button>
      </div>
    </div>`;
    });
  })
  .catch();

categoria.addEventListener("change", () => {
  if (categoria.value == "0") {
    fetch("https://dummyjson.com/products")
      .then((result) => {
        return result.json();
      })
      .then((results2) => {
        productos.innerHTML = `
              `;
        results2.products.forEach((item) => {
          productos.innerHTML += `<div class="card text-center animate__animated animate__flipInX" style="width: 18rem;  background-color: plum;">
              <div class="card-header m-2 bg-transparent border-success"><img src='${item.thumbnail}' class="card-img-top" alt="..."></div>
              <div class="card-body">
              <h5 class="card-title">${item.title}</h5>
              <p class="card-text">${item.description}</p>
              <p class="card-text">Evaluación: ${item.rating}</p>
              <p class="card-text">Stock: ${item.stock}unidades</p>
              <p class="card-text">Precio:${item.price}€</p>
              <p class="card-text">Descuento: ${item.discountPercentage}</p>
              </div>
              <div class="card-footer bg-transparent border-success">  
              <button onclick="comprar(${item.id})" class="btn btn-success">Comprar ${item.title}</button>
            </div>
          </div>`;
        });
      });
  }
  if (categoria.value == "smartphones") {
    fetch("https://dummyjson.com/products/category/smartphones")
      .then((result) => {
        return result.json();
      })
      .then((results2) => {
        productos.innerHTML = `
            `;
        results2.products.forEach((item) => {
          productos.innerHTML += `<div class="card text-center animate__animated animate__flipInY" style="width: 18rem; background-color: plum;">
            <div class="card-header m-2 bg-transparent border-success"><img src='${item.thumbnail}' class="card-img-top" alt="..."></div>
            <div class="card-body">
            <h5 class="card-title">${item.title}</h5>
            <p class="card-text">${item.description}</p>
            <p class="card-text">Evaluación: ${item.rating}</p>
            <p class="card-text">Stock: ${item.stock}unidades</p>
            <p class="card-text">Precio:${item.price}€</p>
            <p class="card-text">Descuento: ${item.discountPercentage}</p>
            </div>
            <div class="card-footer bg-transparent border-success">  
            <button onclick="comprar(${item.id})" class="btn btn-success">Comprar ${item.title}</button>
          </div>
        </div>`;
        });
      });
  }
  if (categoria.value == "laptops") {
    fetch("https://dummyjson.com/products/category/laptops")
      .then((result) => {
        return result.json();
      })
      .then((results2) => {
        productos.innerHTML = `
              `;
        results2.products.forEach((item) => {
          productos.innerHTML += `<div class="card text-center animate__animated animate__zoomIn" style="width: 18rem; background-color: plum;">
              <div class="card-header m-2 bg-transparent border-success"><img src='${item.thumbnail}' class="card-img-top" alt="..."></div>
              <div class="card-body">
              <h5 class="card-title">${item.title}</h5>
              <p class="card-text">${item.description}</p>
              <p class="card-text">Evaluación: ${item.rating}</p>
              <p class="card-text">Stock: ${item.stock}unidades</p>
              <p class="card-text">Precio:${item.price}€</p>
              <p class="card-text">Descuento: ${item.discountPercentage}</p>
              </div>
              <div class="card-footer bg-transparent border-success">  
              <button onclick="comprar(${item.id})" class="btn btn-success">Comprar ${item.title}</button>
            </div>
          </div>`;
        });
      });
  }
  if (categoria.value == "fragrances") {
    fetch("https://dummyjson.com/products/category/fragrances")
      .then((result) => {
        return result.json();
      })
      .then((results2) => {
        productos.innerHTML = `
              `;
        results2.products.forEach((item) => {
          productos.innerHTML += `<div class="card text-center animate__animated animate__slideInUp" style="width: 18rem; background-color: plum;">
              <div class="card-header m-2 bg-transparent border-success"><img src='${item.thumbnail}' class="card-img-top" alt="..."></div>
              <div class="card-body">
              <h5 class="card-title">${item.title}</h5>
              <p class="card-text">${item.description}</p>
              <p class="card-text">Evaluación: ${item.rating}</p>
              <p class="card-text">Stock: ${item.stock}unidades</p>
              <p class="card-text">Precio:${item.price}€</p>
              <p class="card-text">Descuento: ${item.discountPercentage}</p>
              </div>
              <div class="card-footer bg-transparent border-success">  
              <button onclick="comprar(${item.id})" class="btn btn-success">Comprar ${item.title}</button>
            </div>
          </div>`;
        });
      });
  }
  if (categoria.value == "skincare") {
    fetch("https://dummyjson.com/products/category/skincare")
      .then((result) => {
        return result.json();
      })
      .then((results2) => {
        productos.innerHTML = `
              `;
        results2.products.forEach((item) => {
          productos.innerHTML += `<div class="card text-center animate__animated animate__fadeInRight" style="width: 18rem; background-color: plum;">
              <div class="card-header m-2 bg-transparent border-success"><img src='${item.thumbnail}' class="card-img-top" alt="..."></div>
              <div class="card-body">
              <h5 class="card-title">${item.title}</h5>
              <p class="card-text">${item.description}</p>
              <p class="card-text">Evaluación: ${item.rating}</p>
              <p class="card-text">Stock: ${item.stock}unidades</p>
              <p class="card-text">Precio:${item.price}€</p>
              <p class="card-text">Descuento: ${item.discountPercentage}</p>
              </div>
              <div class="card-footer bg-transparent border-success">  
              <button onclick="comprar(${item.id})" class="btn btn-success">Comprar ${item.title}</button>
            </div>
          </div>`;
        });
      });
  }
  if (categoria.value == "groceries") {
    fetch("https://dummyjson.com/products/category/groceries")
      .then((result) => {
        return result.json();
      })
      .then((results2) => {
        productos.innerHTML = `
              `;
        results2.products.forEach((item) => {
          productos.innerHTML += `<div class="card text-center animate__animated animate__bounceInDown" style="width: 18rem; background-color: plum;">
              <div class="card-header m-2 bg-transparent border-success"><img src='${item.thumbnail}' class="card-img-top" alt="..."></div>
              <div class="card-body">
              <h5 class="card-title">${item.title}</h5>
              <p class="card-text">${item.description}</p>
              <p class="card-text">Evaluación: ${item.rating}</p>
              <p class="card-text">Stock: ${item.stock}unidades</p>
              <p class="card-text">Precio:${item.price}€</p>
              <p class="card-text">Descuento: ${item.discountPercentage}</p>
              </div>
              <div class="card-footer bg-transparent border-success">  
              <button onclick="comprar(${item.id})" class="btn btn-success">Comprar ${item.title}</button>
            </div>
          </div>`;
        });
      });
  }
  if (categoria.value == "home-decoration") {
    fetch("https://dummyjson.com/products/category/home-decoration")
      .then((result) => {
        return result.json();
      })
      .then((results2) => {
        productos.innerHTML = `
              `;
        results2.products.forEach((item) => {
          productos.innerHTML += `<div class="card text-center animate__animated animate__fadeInLeft" style="width: 18rem; background-color: plum;">
              <div class="card-header m-2 bg-transparent border-success"><img src='${item.thumbnail}' class="card-img-top" alt="..."></div>
              <div class="card-body">
              <h5 class="card-title">${item.title}</h5>
              <p class="card-text">${item.description}</p>
              <p class="card-text">Evaluación: ${item.rating}</p>
              <p class="card-text">Stock: ${item.stock}unidades</p>
              <p class="card-text">Precio:${item.price}€</p>
              <p class="card-text">Descuento: ${item.discountPercentage}</p>
              </div>
              <div class="card-footer bg-transparent border-success">  
              <button onclick="comprar(${item.id})" class="btn btn-success">Comprar ${item.title}</button>
            </div>
          </div>`;
        });
      })
      .catch();
  }
});

marca.addEventListener("change", () => {
  fetch("https://dummyjson.com/products")
    .then((result) => {
      return result.json();
    })
    .then((results2) => {
      let listaMarcas = results2.products.filter((item) => {
        return item.brand == marca.value;
      });
      productos.innerHTML = `
      `;
      if (marca.value == 0) {
        results2.products.forEach((item) => {
          productos.innerHTML += `<div class="card text-center animate__animated animate__flipInY" style="width: 18rem; background-color: plum;">
            <div class="card-header m-2 bg-transparent border-success"><img src='${item.thumbnail}' class="card-img-top" alt="..."></div>
            <div class="card-body">
            <h5 class="card-title">${item.title}</h5>
            <p class="card-text">${item.description}</p>
            <p class="card-text">Evaluación: ${item.rating}</p>
            <p class="card-text">Stock: ${item.stock}unidades</p>
            <p class="card-text">Precio:${item.price}€</p>
            <p class="card-text">Descuento: ${item.discountPercentage}</p>
            </div>
            <div class="card-footer bg-transparent border-success">  
            <button onclick="comprar(${item.id})" class="btn btn-success">Comprar ${item.title}</button>
          </div>
        </div>`;
        });
      } else {
        mostrarResultados(listaMarcas);
      }
    })
    .catch();
});

btnMin.addEventListener("click", () => {
  fetch("https://dummyjson.com/products")
    .then((result) => {
      return result.json();
    })
    .then((results2) => {
      let listaPrecios = results2.products.filter((item) => {
        return item.price >= InputPrecio.value;
      });
      productos.innerHTML = `
      `;
      mostrarResultados(listaPrecios);
    })
    .catch();
});

function mostrarResultados(lista) {
  lista.forEach((item) => {
    productos.innerHTML += `<div class="card text-center animate__animated animate__lightSpeedInRight" style="width: 18rem; background-color: plum;">
    <div class="card-header m-2 bg-transparent border-success"><img src='${item.thumbnail}' class="card-img-top" alt="..."></div>
    <div class="card-body">
    <h5 class="card-title">${item.title}</h5>
    <p class="card-text">${item.description}</p>
    <p class="card-text">Evaluación: ${item.rating}</p>
    <p class="card-text">Stock: ${item.stock}unidades</p>
    <p class="card-text">Precio:${item.price}€</p>
    <p class="card-text">Descuento: ${item.discountPercentage}</p>
    </div>
    <div class="card-footer bg-transparent border-success">  
    <button onclick="comprar(${item.id})" class="btn btn-success">Comprar ${item.title}</button>
  </div>
</div>`;
  });
}

function comprar(element) {
  fetch("https://dummyjson.com/products")
    .then((result) => {
      return result.json();
    })
    .then((results2) => {
      results2.products.filter((item) => {
        if (item.id == element) {
          cosa = new Producto(
            item.id,
            item.title,
            item.description,
            item.price,
            item.discountPercentage,
            item.rating,
            item.stock,
            item.brand,
            item.category,
            item.thumbnail,
            item.images
          );
          carrito.innerHTML += `<div class="card mt-4 animate__animated animate__tada">
          <div class="card-header m-2 bg-transparent border-success"><img src='${cosa.thumbnail}' class="card-img-top" alt="..."></div>
          <div class="card-body">
          <p class="card-text">${cosa.title}</p>
          </div>
          <div class="card-footer">
          ${cosa.price}€
          </div>
          </div>`;
          array.push(cosa);
          Swal.fire({
            title: "Enhorabuena",
            text: "Articulo añadido al carrito",
            icon: "success",
            timer: 1750,
          });
        }
      });
    })
    .catch();
}

btnBorrar.addEventListener("click", () => {
  carrito.innerHTML = ``;
  array = [];
  Swal.fire({
    title: "Atención",
    text: "Articulos eliminados del carrito",
    icon: "warning",
  });
});
