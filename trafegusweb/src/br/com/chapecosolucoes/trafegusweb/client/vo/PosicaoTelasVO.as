package br.com.chapecosolucoes.trafegusweb.client.vo
{
	import br.com.chapecosolucoes.trafegusweb.client.model.MainModel;

	[Bindable]
	public class PosicaoTelasVO
	{
		public function PosicaoTelasVO()
		{
		}
		public function setPosicaoTelasVO(obj:Object):void
		{
			switch(obj.sreg_chave.toString())
			{
				case "gridVeiculosX":
					this.gridVeiculosX = obj.sreg_valor.toString();
					break;
				case "gridVeiculosY":
					this.gridVeiculosY = obj.sreg_valor.toString();
					break;
				case "gridVeiculosPercentWidth":
					this.gridVeiculosPercentWidth = obj.sreg_valor.toString();
					break;
				case "gridVeiculosPercentHeight":
					this.gridVeiculosPercentHeight = obj.sreg_valor.toString();
					break;
				case "mapaGoogleX":
					this.mapaGoogleX = obj.sreg_valor.toString();
					break;
				case "mapaGoogleY":
					this.mapaGoogleY = obj.sreg_valor.toString();
					break;
				case "mapaGooglePercentWidth":
					this.mapaGooglePercentWidth = obj.sreg_valor.toString();
					break;
				case "mapaGooglePercentHeight":
					this.mapaGooglePercentHeight = obj.sreg_valor.toString();
					break;
				case "gridDetalheX":
					this.gridDetalheX = obj.sreg_valor.toString();
					break;
				case "gridDetalheY":
					this.gridDetalheY = obj.sreg_valor.toString();
					break;
				case "gridDetalhePercentWidth":
					this.gridDetalhePercentWidth = obj.sreg_valor.toString();
					break;
				case "gridDetalhePercentHeight":
					this.gridDetalhePercentHeight = obj.sreg_valor.toString();
					break;
				default:
					break;
			}
		}
		//--- Variaveis de posicionamento do Grid de veiculos
		public var gridVeiculosX:int = 0;
		
		public var gridVeiculosY:int = 20;
		
		public var gridVeiculosPercentWidth:int = 20;
		
		public var gridVeiculosPercentHeight:int = 100;
		
		//--- Variaveis de posicionamento do Google Maps
		public var mapaGoogleX:int = 272;
		
		public var mapaGoogleY:int = 20;
		
		public var mapaGooglePercentWidth:int = 80;
		
		public var mapaGooglePercentHeight:int = 50;
		
		//--- Variaveis de posicionamento do Grid de detalhe
		public var gridDetalheX:int = 272;
		
		public var gridDetalheY:int = 274;
		
		public var gridDetalhePercentWidth:int = 80;
		
		public var gridDetalhePercentHeight:int = 50;
	}
}