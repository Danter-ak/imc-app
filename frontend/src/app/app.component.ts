import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  standalone: false,
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'frontend';

  taille: number = 0;
  poids: number = 0;
  imc: number | null = null;
  categorie: string = '';

  calculerIMC(): void {
    if (this.taille <= 0 || this.poids <= 0) {
      this.imc = null;
      this.categorie = 'Veuillez entrer une taille et un poids valides';
      return;
    }

    this.imc = this.poids / (this.taille * this.taille);

    if (this.imc < 18.5) {
      this.categorie = 'Insuffisance pondérale';
    } else if (this.imc < 25) {
      this.categorie = 'Poids normal';
    } else if (this.imc < 30) {
      this.categorie = 'Surpoids';
    } else {
      this.categorie = 'Obésité';
    }
  }
  getCouleurCategorie(): string {
    switch (this.categorie) {
      case 'Insuffisance pondérale':
        return 'blue';
      case 'Poids normal':
        return 'green';
      case 'Surpoids':
        return 'orange';
      case 'Obésité':
        return 'red';
      case 'Veuillez entrer une taille et un poids valides':
        return 'darkgray';
      default:
        return 'black';
    }
  }
}
