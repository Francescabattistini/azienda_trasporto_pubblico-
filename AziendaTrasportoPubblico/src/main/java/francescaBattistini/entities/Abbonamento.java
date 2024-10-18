package francescaBattistini.entities;

import francescaBattistini.Enum.PeriodoAbbonamento;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "abbonamenti")
public class Abbonamento {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "tipo_abbonamento", nullable = false)
    @Enumerated(EnumType.STRING)
    private PeriodoAbbonamento tipoAbbonamento;
    @Column(name="data_emissione",nullable = false)
    private LocalDate dataEmissione;

    @Column(name="data_scadenza",nullable = false)
    private LocalDate dataScadenza;

    @ManyToOne
    @JoinColumn(name = "id_tessera")
    private Tessera idTessera;

    @ManyToOne
    @JoinColumn(name = "id_rivenditore")
    private Rivenditore idRivenditore;

    @OneToMany(mappedBy = "abbonamenti")
    private List<Validazione> idValidazione;

    public Abbonamento() {
    }

    public Abbonamento(UUID id, PeriodoAbbonamento tipoAbbonamento, LocalDate dataEmissione, LocalDate dataScadenza) {
        this.id = id;
        this.tipoAbbonamento = tipoAbbonamento;
        this.dataEmissione = dataEmissione;
        this.dataScadenza = dataScadenza;
    }

    public UUID getId() {
        return id;
    }

    public LocalDate getDataEmissione() {
        return dataEmissione;
    }

    public void setDataEmissione(LocalDate dataEmissione) {
        this.dataEmissione = dataEmissione;
    }

    public LocalDate getDataScadenza() {
        return dataScadenza;
    }

    public void setDataScadenza(LocalDate dataScadenza) {
        this.dataScadenza = dataScadenza;
    }

    public PeriodoAbbonamento getTipoAbbonamento() {
        return tipoAbbonamento;
    }

    public void setTipoAbbonamento(PeriodoAbbonamento tipoAbbonamento) {
        this.tipoAbbonamento = tipoAbbonamento;
    }

    public Rivenditore getIdRivenditore() {
        return idRivenditore;
    }

    public void setIdRivenditore(Rivenditore idRivenditore) {
        this.idRivenditore = idRivenditore;
    }

    @Override
    public String toString() {
        return "Abbonamenti{" +
                "id=" + id +
                ", tipoAbbonamento=" + tipoAbbonamento +
                ", dataEmissione=" + dataEmissione +
                ", dataScadenza=" + dataScadenza +
                '}';
    }
}
