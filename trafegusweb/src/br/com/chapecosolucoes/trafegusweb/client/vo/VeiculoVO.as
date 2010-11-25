package br.com.chapecosolucoes.trafegusweb.client.vo
{
	public class VeiculoVO
	{
		public function VeiculoVO(obj:Object)
		{
			this.cod = obj.oras_codigo.toString();
			this.vehiclePlate = obj.veic_placa.toString();
			this.desc = obj.tvei_descricao.toString();
		}
		public var cod:String;
		public var vehiclePlate:String;
		public var desc:String;
	}
}