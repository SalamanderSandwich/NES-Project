# NES-Project
Program for modifying text in NES roms

## How to help
```Java
//GENERIC SETUP
for(String s : new String[]{"HASH_THING"})//GAME NAME
{
    if(s.equals(hash))
    {
        return new ROMObject(new ROMIndex[]
        {
            new ROMIndex(0xHEX_ADDRESS, "TEXT"),
        },
        "TABLE");
    }
}
```
Reccomended programs are [FCEUX](www.fceux.com) and [Oriton](https://www.romhacking.net/utilities/709/).

Get hash by opening the program in your terminal/cmd thing.

Get HEX_ADDRESS and "TEXT" like you normally would for hacking ROMS.

Get table by making it like normal in Oriton, but then replace empty blocks with some character that isn't used. Select all blocks and copy paste it into a text editor. Replace all of the previous characters with '\b' (yeah I know it's kinda hacky), that's the table string.

