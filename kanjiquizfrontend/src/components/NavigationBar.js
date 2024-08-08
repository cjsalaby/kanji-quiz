import {AppBar, Button, Icon, IconButton, Stack, Toolbar, Typography} from "@mui/material";
import MenuIcon from "@mui/icons-material/Menu";
import MuiDrawer from "../components/MuiDrawer"

export default function NavigationBar() {
    return (
      <AppBar position={"static"}>
          <Toolbar>
              <MuiDrawer />
              <Typography variant={"h6"} component={"div"} sx={{flexGrow: 1}}>Kanji Quiz</Typography>
              <Stack direction={"row"} spacing={2}>
                  <Button href={"/about"} color={"inherit"}>About</Button>
                  <Button href={"/login"} color={"inherit"}>login</Button>
                  <Button href={"/"} color={"inherit"}>Home</Button>
              </Stack>
          </Toolbar>
      </AppBar>
    );
};