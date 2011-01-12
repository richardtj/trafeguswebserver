package br.com.chapecosolucoes.trafegusweb.client.vo
{
	[Bindable]
	public class MonitoringRequestVO
	{
		public function MonitoringRequestVO()
		{
		}
		public function setMonitoringRequestVO(obj:Object):void
		{
			
		}
		public var tipoViagem:TipoTransporteVO = new TipoTransporteVO();
		public var viagemPai:ViagemPaiVO = new ViagemPaiVO();;
		public var transportador:TransportadorVO = new TransportadorVO();
		public var embarcador:EmbarcadorVO = new EmbarcadorVO();
		public var veiculo:VeiculoVO = new VeiculoVO();
		public var motorista:MotoristaVO = new MotoristaVO();
		public var pgr:PGRVO = new PGRVO();
		public var rota:RouteVO = new RouteVO();
		public var origem:LocalVO = new LocalVO();
		public var destino:LocalVO = new LocalVO();
		public var prevInicio:String;
		public var prevDestino:String;
	}
}