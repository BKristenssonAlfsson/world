export class Url {

  private base_url: string = "http://localhost:8080";
  private continent: string = "/world/world/continent";
  private cities: string = "/world/world/city";
  private languages: string = "/world/world/language";
  private country: string = "/world/world/country";

  getBaseUrl() {
    return this.base_url;
  }

  getContinents() {
    return this.continent;
  }

  getCities() {
    return this.cities;
  }

  getCountries() {
    return this.country;
  }

  getLanguages() {
    return this.languages;
  }
}
