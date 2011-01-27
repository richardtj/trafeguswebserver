package br.com.chapecosolucoes.trafegusweb.client.vo
{
	import mx.collections.SortField;

	[Bindable]
	public class VeiculoVO
	{
		public function VeiculoVO()
		{
		}
		public function setVeiculoVO(obj:Object):void
		{
			this.cod = obj.veic_oras_codigo.toString();
			this.vveiCodigo = obj.vvei_codigo.toString();
			this.vveiEvcaCodigo = obj.vvei_evca_codigo.toString();
			this.vveiMotoPfisPessOrasCodigo = obj.vvei_moto_pfis_pess_oras_codigo.toString();
			this.vehiclePlate = obj.veic_placa.toString();
			this.desc = obj.tvei_descricao.toString();
			this.cor = obj.veic_cor.toString();
			this.seq = obj.vvei_sequencia.toString();
			this.precedencia = obj.vvei_precedencia.toString();
		}
		public function set vvei_veic_oras_codigo(vvei_veic_oras_codigo:String):void
		{
			this.cod = vvei_veic_oras_codigo;
		}
		public function get vvei_veic_oras_codigo():String
		{
			return this.cod;
		}
		public function get vvei_codigo():String
		{
			return this.vveiCodigo==""?"nextval('s_vvei_viagem_veiculo')":this.vveiCodigo;
		}
		public function set vvei_sequencia(vvei_sequencia:String):void
		{
			this.seq = vvei_sequencia;
		}
		public function get vvei_sequencia():String
		{
			return this.seq;
		}
		public var cod:String;
		public var vveiCodigo:String;
		public var vehiclePlate:String;
		public var desc:String;
		public var cor:String;
		public var seq:String;
		public var precedencia:String;
		public var vvei_precedencia:String;
		public var vveiEvcaCodigo:String;
		public var vveiMotoPfisPessOrasCodigo:String;
		public var selected:Boolean=false;
	}
}