// Enum para tipos de ambientes marinhos
enum class TipoAmbienteMarinho {
    RECIFE_DE_CORAL,
    PRADERIA_DEERAS,
    MAR_ABERTO,
    ZONA_COSTEIRA
}

// Classe base
open class ConservacaoMarinha(
    tipoAmbiente: TipoAmbienteMarinho,
    areaProtegidaEmKm2: Double,
    possuiProgramaMonitoramento: Boolean
) {
    // Propriedades com lateinit
    lateinit var tipoAmbiente: TipoAmbienteMarinho
    var areaProtegidaEmKm2: Double = areaProtegidaEmKm2
    var possuiProgramaMonitoramento: Boolean = possuiProgramaMonitoramento

    init {
        this.tipoAmbiente = tipoAmbiente
    }

    open fun mostrarInformacoes() {
        println("Tipo de Ambiente: $tipoAmbiente")
        println("Área Protegida: $areaProtegidaEmKm2 km²")
        println("Possui Programa de Monitoramento: $possuiProgramaMonitoramento")
    }
}

// Subclasse para ReservaMarinha
class ReservaMarinha(
    tipoAmbiente: TipoAmbienteMarinho,
    areaProtegidaEmKm2: Double,
    possuiProgramaMonitoramento: Boolean
) : ConservacaoMarinha(tipoAmbiente, areaProtegidaEmKm2, possuiProgramaMonitoramento) {
    // Propriedade específica para ReservaMarinha com lateinit
    lateinit var tipoReserva: String

    fun definirTipoReserva(tipoReserva: String) {
        this.tipoReserva = tipoReserva
    }

    override fun mostrarInformacoes() {
        with(this) {
            println("Tipo de Ambiente: $tipoAmbiente")
            println("Área Protegida: $areaProtegidaEmKm2 km²")
            println("Possui Programa de Monitoramento: $possuiProgramaMonitoramento")
            println("Tipo de Reserva: $tipoReserva")
        }
    }
}

// Subclasse para AreaProtegidaMarinha
class AreaProtegidaMarinha(
    tipoAmbiente: TipoAmbienteMarinho,
    areaProtegidaEmKm2: Double,
    possuiProgramaMonitoramento: Boolean
) : ConservacaoMarinha(tipoAmbiente, areaProtegidaEmKm2, possuiProgramaMonitoramento) {
    // Propriedade específica para AreaProtegidaMarinha com lateinit
    lateinit var tipoProtecao: String

    fun definirTipoProtecao(tipoProtecao: String) {
        this.tipoProtecao = tipoProtecao
    }

    override fun mostrarInformacoes() {
        with(this) {
            println("Tipo de Ambiente: $tipoAmbiente")
            println("Área Protegida: $areaProtegidaEmKm2 km²")
            println("Possui Programa de Monitoramento: $possuiProgramaMonitoramento")
            println("Tipo de Proteção: $tipoProtecao")
        }
    }
}

// Função principal para teste
fun main() {
    val reserva = ReservaMarinha(
        TipoAmbienteMarinho.RECIFE_DE_CORAL,
        150.0,
        true
    )
    reserva.definirTipoReserva("Reserva Natural")

    val areaProtegida = AreaProtegidaMarinha(
        TipoAmbienteMarinho.ZONA_COSTEIRA,
        500.0,
        false
    )
    areaProtegida.definirTipoProtecao("Proteção Total")

    println("Informações da Reserva Marinha:")
    reserva.mostrarInformacoes()

    println("\nInformações da Área Protegida Marinha:")
    areaProtegida.mostrarInformacoes()
}
