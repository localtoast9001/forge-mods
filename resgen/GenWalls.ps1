$wallTypes = gc .\walltypes.txt
$wallTextures = gc .\walltextures.txt
$template = gc .\blockstates_wall.json
$template_post = gc .\wall_post.json
$template_side = gc .\wall_side.json
$template_inventory = gc .\wall_inventory.json
$template_item = gc .\item_wall.json
$i = 0
foreach ($wallType in $wallTypes) {
  $walltexture = $wallTextures[$i]
  $template | %{$_ -replace '\$\(TYPE\)',$wallType} | sc ('..\src\main\resources\assets\morematerials\blockstates\{0}_wall.json' -f $wallType)
  $template_item | %{$_ -replace '\$\(TYPE\)',$wallType} | sc ('..\src\main\resources\assets\morematerials\models\item\{0}_wall.json' -f $wallType)
  $template_post | %{$_ -replace '\$\(TEXTURE\)',$wallTexture} | sc ('..\src\main\resources\assets\morematerials\models\block\{0}_wall_post.json' -f $wallType)
  $template_side | %{$_ -replace '\$\(TEXTURE\)',$wallTexture} | sc ('..\src\main\resources\assets\morematerials\models\block\{0}_wall_side.json' -f $wallType)
  $template_inventory | %{$_ -replace '\$\(TEXTURE\)',$wallTexture} | sc ('..\src\main\resources\assets\morematerials\models\block\{0}_wall_inventory.json' -f $wallType)
  $i += 1
}