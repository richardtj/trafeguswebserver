package br.com.chapecosolucoes.trafegusweb.client.vo.grids
{
    import br.com.chapecosolucoes.trafegusweb.client.utils.XmlUtils;

    import mx.collections.ArrayCollection;

    public class GridConfig
    {
        private var grids:ArrayCollection

        public function GridConfig()
        {
            grids = new ArrayCollection();
        }
        ;

        public function toXML():String
        {
            return XmlUtils.objectToXml(grids.source);
        }

        public function addGrid(grid:Grid):void
        {
            var i:int = findGrid(grid);
            if (i < 0)
            {
                grids.addItem(grid);
            }
        }

        private function findGrid(grid:Grid):int
        {
            for (var i:int = 0; i < grids.length; i++)
            {
                if (Grid(grids.getItemAt(i)).nome == grid.nome)
                {
                    return i;
                }
            }
            return -1;
        }
    }
}