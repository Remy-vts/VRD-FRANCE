function ConfirmMessage(idChantier) {
       if (confirm("Etes-vous sûr de vouloir supprimer définitivement cette réalisation ?")) {
           window.location("deleteChantier?c="+idChantier);
       }
   }

function ConfirmPresse(idPresse) {
    if (confirm("Etes-vous sûr de vouloir supprimer définitivement cet article ?")) {
        window.location("deletePresse?p="+idPresse);
    }
}

function ConfirmOffre(idOffre) {
    if (confirm("Etes-vous sûr de vouloir supprimer définitivement cette offre ?")) {
        window.location("deleteOffre?o="+idOffre);
    }
}