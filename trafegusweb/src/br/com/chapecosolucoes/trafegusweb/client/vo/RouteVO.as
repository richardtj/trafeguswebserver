package br.com.chapecosolucoes.trafegusweb.client.vo
{
	[Bindable]
	public class RouteVO
	{
		public function RouteVO()
		{
			
		}
		public function setRouteVO(obj:Object):void
		{
			this.codigo = obj.rota_codigo.toString();
			this.descricao = obj.rota_descricao.toString();
			this.distancia = obj.rota_distancia.toString();
			this.coordenada = obj.rota_coordenada.toString();
			this.dataCadastro = obj.rota_data_cadastro.toString();
			this.coordenadasPipe = obj.rota_coordenadaspipe.toString();
		}
		public var codigo:String;
		public var descricao:String;
		public var distancia:String;
		public var coordenada:String;
		public var dataCadastro:String;
		public var coordenadasPipe:String;
	}
}