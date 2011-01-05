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
    
    import com.google.maps.overlays.Polyline;
    
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
		
		public var rota:Polyline = null;
		
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
		
		[ArrayElementType("br.com.chapecosolucoes.trafegusweb.client.vo.ReferenciaVO")]
		public var referencias:ArrayCollection = new ArrayCollection();
		
		[ArrayElementType("com.google.maps.overlays.Marker")]
		public var markers:ArrayCollection = new ArrayCollection();
		
		[Embed(source="assets/map/apartment.png")]
		private var outrasCidades:Class;
		
		[Embed(source="assets/map/regroup.png")]
		private var referenciaGenerica:Class;
		
		[Embed(source="assets/map/tollstation.png")]
		private var pedagios:Class;
		
		[Embed(source="assets/map/police2.png")]
		private var policiaRodoviariaFederal:Class;
		
		[Embed(source="assets/map/gazstation.png")]
		private var postosCombustivel:Class;
		
		[Embed(source="assets/map/firstaid.png")]
		private var hospitais:Class;
		
		[Embed(source="assets/map/hotel.png")]
		private var hoteis:Class;
		
		[Embed(source="assets/map/white20.png")]
		private var marcoQuilometrico:Class;
		
		[Embed(source="assets/map/police.png")]
		private var delegacias:Class;
		
		[Embed(source="assets/map/port.png")]
		private var portos:Class;
		
		[Embed(source="assets/map/airport.png")]
		private var aeroportos:Class;
		
		[Embed(source="assets/map/police3.png")]
		private var policiaRodoviariaEstadual:Class;
		
		[Embed(source="assets/map/tools.png")]
		private var manutencao:Class;
		
		[Embed(source="assets/map/bigcity2.png")]
		private var capitais:Class;
		
		[Embed(source="assets/map/bigcity.png")]
		private var cidadesGrandes:Class;
		
		[Embed(source="assets/map/smallcity2.png")]
		private var cidadesMedias:Class;
		
		[Embed(source="assets/map/smallcity.png")]
		private var cidadesPequenas:Class;
		
		[Embed(source="assets/map/agriculture2.png")]
		private var cidadesMuitoPequenas:Class;
		
		[Embed(source="assets/map/villa-tourism.png")]
		private var cidades:Class;
		
		[Embed(source="assets/map/wifi2.png")]
		private var perdaSinal:Class;
		
		[Embed(source="assets/map/court.png")]
		private var balanca:Class;
		
		[Embed(source="assets/map/truck.png")]
		private var cargaDescarga:Class;
		
		[Embed(source="assets/map/police5.png")]
		private var policia:Class;
		
		[Embed(source="assets/map/country.png")]
		private var referenciasGerais:Class;
		
		public function getClassesReferenciaIcons(value:int):Class
		{
			switch(value)
			{
				case 1:
					return this.outrasCidades;
				case 2:
					return this.pedagios;
				case 3:
					return this.policiaRodoviariaFederal;
				case 4:
					return this.postosCombustivel;
				case 5:
					return this.hospitais;
				case 6:
					return this.hoteis;
				case 7:
					return this.marcoQuilometrico;
				case 8:
					return this.delegacias;
				case 9:
					return this.portos;
				case 10:
					return this.aeroportos;
				case 11:
					return this.policiaRodoviariaEstadual;
				case 12:
					return this.manutencao;
				case 13:
					return this.capitais;
				case 14:
					return this.cidadesGrandes;
				case 15:
					return this.cidadesMedias;
				case 16:
					return this.cidadesPequenas;
				case 17:
					return this.cidadesMuitoPequenas;
				case 18:
					return this.cidades;
				case 19:
					return this.perdaSinal;
				case 20:
					return this.balanca;
				case 21:
					return this.cargaDescarga;
				case 22:
					return this.policia;
				case 23:
					return this.cargaDescarga;
				case 25:
					return this.referenciasGerais;
				default:
					return this.referenciaGenerica; 
			}
		}
		
		
        public function MainModel(enforcer:SingletonEnforcer)
        {
            if (enforcer == null)
            {
                throw new Error("Só pode haver uma instância de [MainModel]");
            }
        }
		
		public function cleanUp():void
		{
			instance = null;
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