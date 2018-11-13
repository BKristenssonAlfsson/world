export class Url {

  private base_url: string = "http://localhost:8080";
  private continent: string = "/world/continent";
  private cities: string = "/world/city";
  private languages: string = "/world/language";
  private country: string = "/world/country";

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
