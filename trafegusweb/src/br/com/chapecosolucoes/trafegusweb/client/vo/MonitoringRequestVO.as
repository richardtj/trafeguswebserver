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
		public var transportador:String;
		public var embarcador:String;
		public var veiculo:String;
		public var placa:String;
		public var motorista:String;
		public var pgr:String;
		public var rota:String;
		public var origem:String;
		public var destino:String;
		public var prevInicio:String;
		public var prevDestino:String;
	}
}