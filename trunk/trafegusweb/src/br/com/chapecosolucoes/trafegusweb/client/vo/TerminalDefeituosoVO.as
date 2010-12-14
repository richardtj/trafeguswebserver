package br.com.chapecosolucoes.trafegusweb.client.vo
{
	[Bindable]
	public class TerminalDefeituosoVO
	{
		public function TerminalDefeituosoVO()
		{
		}
		public function setTerminalDefeituosoVO(obj:Object):void
		{
			this.codigo = obj.ppad_codigo.toString();
			this.descricao = obj.ppad_descricao.toString();
			this.pperInicioProblema = obj.pper_data_inicio_problema.toString();
			this.pperDescricao = obj.pper_descricao.toString();
		}
		public var codigo:String;
		public var descricao:String;
		public var pperInicioProblema:String;
		public var pperDescricao:String;
	}
}