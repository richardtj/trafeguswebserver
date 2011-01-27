package br.com.chapecosolucoes.trafegusweb.client.vo
{
	import br.com.chapecosolucoes.trafegusweb.client.utils.MyDateFormatter;
	
	import mx.collections.ArrayCollection;
	import mx.collections.Sort;
	import mx.collections.SortField;

	[Bindable]
	public class MonitoringRequestVO
	{
		public function MonitoringRequestVO()
		{
			dataSortField = new SortField();
			dataSortField.name = "seq";
			dataSortField.numeric = true;
			numericDataSort = new Sort();
			numericDataSort.fields = [dataSortField];
			this.carretas.sort = numericDataSort;
		}
		public function setMonitoringRequestVO(obj:Object):void
		{
			this.codigoTipoViagem = obj.ttra_codigo.toString();
			this.descricaoTipoViagem = obj.ttra_descricao.toString();
			this.codigoViagemPai = obj.viag_codigo_pai.toString();
			this.codigoTransportador = obj.codigo_transportador.toString();
			this.nomeTransportador = obj.nome_transportador.toString();
			this.codigoEmbarcador = obj.codigo_embarcador.toString();
			this.nomeEmbarcador = obj.nome_embarcador.toString();
			this.codigoMotorista = obj.codigo_motorista.toString();
			this.nomeMotorista = obj.nome_motorista.toString();
			this.numeroViagem = obj.viag_codigo.toString();
			this.operacao = obj.viag_tope_codigo.toString();
			
			this.veiculoPrincipal.setVeiculoVO(obj);
			
			this.terminal = obj.term_numero_terminal.toString();
			this.dataCadastro = obj.viag_data_cadastro.toString();
			this.codigoOrigem = obj.codigo_origem.toString();
			this.descricaoOrigem = obj.descricao_origem.toString();
			this.codigoDestino = obj.codigo_destino.toString();
			this.descricaoDestino = obj.descricao_destino.toString();
			this.prevInicio = obj.viag_previsao_inicio.toString();
			this.prevFim = obj.viag_previsao_fim.toString();
			this.codigoRota = obj.rota_codigo.toString();
			this.descricaoRota = obj.rota_descricao.toString();
			this.codigoPGR = obj.pgpg_codigo.toString();
			this.descricaoPGR = obj.pgpg_descricao.toString();
			this.prevHoraInicio = obj.viag_previsao_hora_inicio.toString();
			this.prevHoraFim = obj.viag_previsao_hora_fim.toString();
			this.distancia = obj.viag_distancia.toString();
			this.valor = obj.viag_valor_carga.toString();
			this.inicio = obj.viag_data_inicio.toString();
			this.horaInicio = obj.viag_hora_inicio.toString();
			this.tempMin = obj.vtem_valor_minimo.toString();
			this.tempMax = obj.vtem_valor_maximo.toString();
		}
		public function set viag_codigo(viag_codigo:String):void
		{
			this.numeroViagem = viag_codigo;
		}
		public function get viag_codigo():String
		{
			return numeroViagem;
		}
		public function set viag_codigo_pai(viag_codigo_pai:String):void
		{
			this.codigoViagemPai = viag_codigo_pai;
		}
		public function get viag_codigo_pai():String
		{
			return this.codigoViagemPai==""?"NULL":this.codigoViagemPai;
		}
		public function set viag_data_cadastro(viag_data_cadastro:String):void
		{
			this.dataCadastro = viag_data_cadastro;
		}
		public function get viag_data_cadastro():String
		{
			return ("'"+(this.dataCadastro==""?MyDateFormatter.getInstance().parse(new Date()):this.dataCadastro)+"'");
		}
		public function set viag_previsao_inicio(viag_previsao_inicio:String):void
		{
			this.prevInicio = viag_previsao_inicio;
		}
		public function get viag_previsao_inicio():String
		{
			return "'" + this.prevInicio + this.prevHoraInicio + "'";
		}
		public function set viag_previsao_fim(viag_previsao_fim:String):void
		{
			this.prevFim = viag_previsao_fim
		}
		public function get viag_previsao_fim():String
		{
			return "'" + this.prevFim + this.prevHoraFim + "'" ;
		}
		public function set horaInicio(horaInicio:String):void
		{
			this._horaInicio = horaInicio;
		}
		public function get horaInicio():String
		{
			return this._horaInicio==""?MyDateFormatter.getInstance().parseTime(new Date()):this._horaInicio;
		}
		public function set prevHoraInicio(prevHoraInicio:String):void
		{
			this._prevHoraInicio = prevHoraInicio;
		}
		public function get prevHoraInicio():String
		{
			return this._prevHoraInicio==""?MyDateFormatter.getInstance().parseTime(new Date()):this._prevHoraInicio;
		}
		public function set prevHoraFim(prevHoraFim:String):void
		{
			this._prevHoraFim = prevHoraFim;
		}
		public function get prevHoraFim():String
		{
			return this._prevHoraFim==""?MyDateFormatter.getInstance().parseTime(new Date()):this._prevHoraFim;
		}
		
		public var codigoTipoViagem:String = "";
		public var descricaoTipoViagem:String = "";
		public var codigoViagemPai:String = "";
		public var previsaoInicioViagemPai:String = "";
		public var previsaoFimViagemPai:String = "";
		public var codigoTransportador:String = "";
		public var nomeTransportador:String = "";
		public var codigoEmbarcador:String = "";
		public var nomeEmbarcador:String = "";
		
		public var veiculoPrincipal:VeiculoVO = new VeiculoVO();
		
		public var codigoMotorista:String = "";
		public var nomeMotorista:String = "";
		public var codigoPGR:String = "";
		public var descricaoPGR:String = "";
		public var codigoRota:String = "";
		public var descricaoRota:String = "";
		public var codigoOrigem:String = "";
		public var descricaoOrigem:String = "";
		public var codigoDestino:String = "";
		public var descricaoDestino:String = "";
		public var prevInicio:String = "";
		private var _prevHoraInicio:String = "";
		public var prevFim:String = "";
		private var _prevHoraFim:String = "";
		public var dataCadastro:String = "";
		public var operacao:String = "";
		public var numeroViagem:String = "nextval('s_viag_viagem')";
		public var terminal:String = "";
		public var valor:String = "";
		public var tempMax:String = "";
		public var tempMin:String = "";
		public var distancia:String = "";
		public var inicio:String = "";
		private var _horaInicio:String = "";
		public var codTerminais:String = "";
		[ArrayElementType("br.com.chapecosolucoes.trafegusweb.client.vo.VeiculoVO")]
		public var carretas:ArrayCollection = new ArrayCollection();
		[ArrayElementType("br.com.chapecosolucoes.trafegusweb.client.vo.ParadaVO")]
		public var paradas:ArrayCollection = new ArrayCollection();
		[ArrayElementType("br.com.chapecosolucoes.trafegusweb.client.vo.TerminalVO")]
		public var terminaisArray:ArrayCollection = new ArrayCollection();
		[ArrayElementType("br.com.chapecosolucoes.trafegusweb.client.vo.TerminalDefeituosoVO")]
		public var terminaisDefeituososArray:ArrayCollection = new ArrayCollection();
		private var numericDataSort:Sort;
		private var dataSortField:SortField;
	}
}