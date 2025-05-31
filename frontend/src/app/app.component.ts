import { Component } from '@angular/core';

import { ImcService } from './imc.service';
import { ImcRecord } from './ImcRecord';

@Component({
  selector: 'app-root',
  standalone: false,
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
   title = 'frontend';
  taille: number = 0;
  poids: number = 0;
  imc: number | null = null;
  categorie: string = '';

  constructor(private imcService: ImcService) {}

  getCouleurCategorie(): string {
    switch (this.categorie) {
      case 'Insuffisance pondérale': return 'blue';
      case 'Poids normal': return 'green';
      case 'Surpoids': return 'orange';
      case 'Obésité': return 'red';
      case 'Veuillez entrer des valeurs valides': return 'darkgray';
      default: return 'black';
    }
  }

  calculerIMC(): void {
    if (this.taille <= 0 || this.poids <= 0) {
      this.imc = null;
      this.categorie = 'Veuillez entrer des valeurs valides';
      return;
    }

    this.imc = this.poids / (this.taille * this.taille);

    if (this.imc < 18.5) this.categorie = 'Insuffisance pondérale';
    else if (this.imc < 25) this.categorie = 'Poids normal';
    else if (this.imc < 30) this.categorie = 'Surpoids';
    else this.categorie = 'Obésité';

    const imcData: ImcRecord = {
      taille: this.taille,
      poids: this.poids,
      imc: this.imc,
      categorie: this.categorie
    };

    this.imcService.enregistrerIMC(imcData).subscribe({
      next: () => console.log("IMC enregistré avec succès"),
      error: (err) => console.error("Erreur lors de l'enregistrement", err)
    });
  }

}
