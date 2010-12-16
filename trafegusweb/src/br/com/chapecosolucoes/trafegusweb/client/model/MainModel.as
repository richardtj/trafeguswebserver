package br.com.chapecosolucoes.trafegusweb.client.model
{
    import br.com.chapecosolucoes.trafegusweb.client.vo.DadosEmbarcadorVO;
    import br.com.chapecosolucoes.trafegusweb.client.vo.DadosLocalVO;
    import br.com.chapecosolucoes.trafegusweb.client.vo.DadosMotoristaVO;
    import br.com.chapecosolucoes.trafegusweb.client.vo.DadosPGRVO;
    import br.com.chapecosolucoes.trafegusweb.client.vo.DadosTransportadorVO;
    import br.com.chapecosolucoes.trafegusweb.client.vo.DadosVeiculoVO;
    import br.com.chapecosolucoes.trafegusweb.client.vo.DadosViagemPaiVO;
    import br.com.chapecosolucoes.trafegusweb.client.vo.EmbarcadorVO;
    import br.com.chapecosolucoes.trafegusweb.client.vo.PosicaoVeiculoVO;
    import br.com.chapecosolucoes.trafegusweb.client.vo.RouteVO;
    import br.com.chapecosolucoes.trafegusweb.client.vo.SolicitacaoMonitoramentoVO;
    import br.com.chapecosolucoes.trafegusweb.client.vo.ViagemPaiVO;
    
    import mx.collections.ArrayCollection;

    [Bindable]
    public final class MainModel
    {
        private static var instance:MainModel;

        public var mapReady:Boolean = false;

        public var veiculoSelecionado:String = "";

        public var historicoSelecionado:String = "";

        public var viagemSelecionada:String = "";

        public var zoomFilter:String = "";

        public var codTerminais:String = "";

        public var posicaoVeiculoVO:PosicaoVeiculoVO = new PosicaoVeiculoVO();

        public var dadosMotoristaVO:DadosMotoristaVO = new DadosMotoristaVO();

        public var dadosVeiculoVO:DadosVeiculoVO = new DadosVeiculoVO();

        public var dadosRotaVO:RouteVO = new RouteVO();

        public var dadosEmbarcadorVO:DadosEmbarcadorVO = new DadosEmbarcadorVO();

        public var dadosTransportadorVO:DadosTransportadorVO = new DadosTransportadorVO();

        public var dadosLocalVO:DadosLocalVO = new DadosLocalVO();

        public var dadosPGRVO:DadosPGRVO = new DadosPGRVO();

        public var dadosViagemPaiVO:ViagemPaiVO = new ViagemPaiVO();

        public var solicitacaoMonitoramentoVO:SolicitacaoMonitoramentoVO = new SolicitacaoMonitoramentoVO();

        public var codEmpresa:int = 0;
		
		public var codUsuario:int = 0;

        public var leftToRightEnabled:Boolean = true;

        public var totalDadosGrid:int = 0;

        public var totalListaLocais:int = 0;

        public var totalListaEmbarcadores:int = 0;

        public var totalListaMotoristas:int = 0;

        public var totalListaPGR:int = 0;

        public var totalListaRotas:int = 0;

        public var totalListaTipoTransporte:int = 0;

        public var totalListaTransportadores:int = 0;

        public var totalListaVeiculos:int = 0;

        public var totalListaViagemPai:int = 0;

        public var totalHistoricoPosicoes:int = 0;

        public var totalVeiculosViagem:int = 0;
		
        [ArrayElementType("br.com.chapecosolucoes.trafegusweb.vo.DataMsg")]
        public var dpMensagens:ArrayCollection;

        [ArrayElementType("br.com.chapecosolucoes.trafegusweb.client.vo.PosicaoVeiculoVO")]
        public var posVeiculosArray:ArrayCollection = new ArrayCollection();

        [ArrayElementType("br.com.chapecosolucoes.trafegusweb.client.vo.HistoricoPosicoesVeiculoVO")]
        public var historicoPosicoesVeiculosArray:ArrayCollection = new ArrayCollection();

        [ArrayElementType("br.com.chapecosolucoes.trafegusweb.client.vo.VeiculoViagemVO")]
        public var veiculosViagemArray:ArrayCollection = new ArrayCollection();

        [ArrayElementType("br.com.chapecosolucoes.trafegusweb.client.vo.VeiculoVO")]
        public var veiculosArray:ArrayCollection = new ArrayCollection();

        [ArrayElementType("br.com.chapecosolucoes.trafegusweb.client.vo.DadosMotoristaVO")]
        public var motoristasArray:ArrayCollection = new ArrayCollection();

        [ArrayElementType("br.com.chapecosolucoes.trafegusweb.client.vo.RouteVO")]
        public var rotasArray:ArrayCollection = new ArrayCollection();

        [ArrayElementType("br.com.chapecosolucoes.trafegusweb.client.vo.EmbarcadorVO")]
        public var embarcadoresArray:ArrayCollection = new ArrayCollection();

        [ArrayElementType("br.com.chapecosolucoes.trafegusweb.client.vo.VeiculoVO")]
        public var carretasSelecionadasArray:ArrayCollection = new ArrayCollection();

        [ArrayElementType("br.com.chapecosolucoes.trafegusweb.client.vo.TransportadorVO")]
        public var transportadoresArray:ArrayCollection = new ArrayCollection();

        [ArrayElementType("br.com.chapecosolucoes.trafegusweb.client.vo.LocalVO")]
        public var locaisArray:ArrayCollection = new ArrayCollection();

        [ArrayElementType("br.com.chapecosolucoes.trafegusweb.client.vo.ParadaVO")]
        public var paradasArray:ArrayCollection = new ArrayCollection();

        [ArrayElementType("br.com.chapecosolucoes.trafegusweb.client.vo.TipoTransporteVO")]
        public var tipoTransporteArray:ArrayCollection = new ArrayCollection();

        [ArrayElementType("br.com.chapecosolucoes.trafegusweb.client.vo.VeiculoVO")]
        public var carretasDisponiveisArray:ArrayCollection = new ArrayCollection();

        [ArrayElementType("br.com.chapecosolucoes.trafegusweb.client.vo.PGRVO")]
        public var pgrArray:ArrayCollection = new ArrayCollection();

        [ArrayElementType("br.com.chapecosolucoes.trafegusweb.client.vo.ViagemPaiVO")]
        public var viagemPaiArray:ArrayCollection = new ArrayCollection();

        [ArrayElementType("br.com.chapecosolucoes.trafegusweb.client.vo.TerminalVO")]
        public var terminaisArray:ArrayCollection = new ArrayCollection();

        [ArrayElementType("br.com.chapecosolucoes.trafegusweb.client.vo.TerminalDefeituosoVO")]
        public var terminaisDefeituososArray:ArrayCollection = new ArrayCollection();

		[ArrayElementType("br.com.chapecosolucoes.trafegusweb.client.vo.ClassesReferenciaVO")]
		public var classesReferencia:ArrayCollection = new ArrayCollection();
		
		public var classesReferenciaIcons:ArrayCollection = new ArrayCollection([{img:"assets/map/apartment.png"},{img:"assets/map/tollstation.png"},{img:"assets/map/police2.png"},{img:"assets/map/gazstation.png"},{img:"assets/map/firstaid.png"},{img:"assets/map/hotel.png"},{img:"assets/map/white20.png"},{img:"assets/map/police.png"},{img:"assets/map/port.png"},{img:"assets/map/airport.png"},{img:"assets/map/police3.png"},{img:"assets/map/tools.png"},{img:"assets/map/bigcity2.png"},{img:"assets/map/bigcity.png"},{img:"assets/map/smallcity2.png"},{img:"assets/map/smallcity.png"},{img:"assets/map/villa-tourism.png"}]);
		
		public var Referencias:ArrayCollection = new ArrayCollection();
		
        public function MainModel(enforcer:SingletonEnforcer)
        {
            if (enforcer == null)
            {
                throw new Error("Só pode haver uma instância de [MainModel]");
            }
        }

        public static function getInstance():MainModel
        {
            if (instance == null)
                instance = new MainModel(new SingletonEnforcer());
            return instance;
        }

    }
}

class SingletonEnforcer
{

}