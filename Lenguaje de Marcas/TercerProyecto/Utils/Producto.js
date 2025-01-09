class Producto {
  id;
  title;
  description;
  price;
  discountPercentage;
  rating;
  stock;
  brand;
  category;
  thumbnail;
  images;

  constructor(
    id,
    title,
    description,
    price,
    discountPercentage,
    rating,
    stock,
    brand,
    category,
    thumbnail,
    images
  ) {
    this.id = id;
    this.title = title;
    this.description = description;
    this.price = price;
    this.discountPercentage = discountPercentage;
    this.rating = rating;
    this.stock = stock;
    this.brand = brand;
    this.category = category;
    this.thumbnail = thumbnail;
    this.images = images;
  }

  get getId() {
    return this.id;
  }
  set setId(id) {
    this.id = id;
  }
  get getTitle() {
    return this.title;
  }
  set setTitle(title) {
    this.title = title;
  }

  get getDescription() {
    return this.description;
  }
  set setDescription(description) {
    this.description = description;
  }
  get getPrice() {
    return this.price;
  }
  set setPrice(price) {
    this.price = price;
  }
  get getDiscountPercentage() {
    return this.discountPercentage;
  }
  set setDiscountPercentage(discountPercentage) {
    this.discountPercentage = discountPercentage;
  }
  get getRating() {
    return this.rating;
  }
  set setRating(rating) {
    this.rating = rating;
  }
  get getStock() {
    return this.stock;
  }
  set setStock(stock) {
    this.stock = stock;
  }
  get getBrand() {
    return this.brand;
  }
  set setBrand(brand) {
    this.brand = brand;
  }
  get getThumbnail() {
    return thumbnail;
  }
  set setThumbnail(thumbnail) {
    this.thumbnail = thumbnail;
  }
  get getImages() {
    return images;
  }
  set setImages(images) {
    this.images = images;
  }
}
