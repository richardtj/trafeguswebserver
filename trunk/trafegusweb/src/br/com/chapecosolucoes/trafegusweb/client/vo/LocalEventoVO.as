package br.com.chapecosolucoes.trafegusweb.client.vo
{
	[Bindable]
	public class LocalEventoVO
	{
		public function LocalEventoVO()
		{
		}
		public function set vlev_codigo(vlev_codigo:String):void{
			this.codigo = vlev_codigo;
		}
		public function get vlev_codigo():String
		{
			return this.codigo;
		}
		public var codigo:String;
	}
}