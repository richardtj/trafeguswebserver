package br.com.chapecosolucoes.trafegusweb.client.vo.grids
{
    import mx.collections.ArrayCollection;

    public class Grid
    {
		public var nome:String;
        public var colunas:ArrayCollection;

        public function Grid()
        {
            colunas = new ArrayCollection();
        }
    }
}