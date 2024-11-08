//package org.lushplugins.regrowthhub.hook.gmusic;
//
//import dev.geco.gmusic.GMusicMain;
//import dev.geco.gmusic.objects.*;
//import me.clip.placeholderapi.expansion.PlaceholderExpansion;
//import org.bukkit.OfflinePlayer;
//
//import java.util.Arrays;
//import java.util.List;
//import java.util.Optional;
//import java.util.UUID;
//
//public class PAPILink extends PlaceholderExpansion {
//
//	private final GMusicMain GPM;
//
//	public PAPILink(GMusicMain GPluginMain) { GPM = GPluginMain; }
//
//	@Override
//	public boolean canRegister() { return true; }
//
//	@Override
//	public String getAuthor() { return GPM.getDescription().getAuthors().toString(); }
//
//	@Override
//	public String getIdentifier() { return GPM.NAME.toLowerCase(); }
//
//	@Override
//	public String getVersion() { return GPM.getDescription().getVersion(); }
//
//	@Override
//	public List<String> getPlaceholders() { return Arrays.asList("options_volume", "options_join", "options_playmode", "options_particles", "options_reverse", "options_toggle", "active", "active_title", "active_id", "active_author", "active_oauthor", "active_description", "active_length", "active_position", "active_paused"); }
//
//	@Override
//	public String onRequest(OfflinePlayer Player, String Identifier) {
//
//        if (Identifier.startsWith("global_")) {
//            switch(Identifier.substring(Identifier.indexOf("_") + 1)) {
//                case "title": {
//                    if (GPM.getValues().getJukeBlocks().size() == 0) return "";
//
//                    Optional<UUID> boxUuidOpt = GPM.getValues().getJukeBlocks().keySet().stream().findFirst();
//                    if (boxUuidOpt.isPresent()) {
//                        UUID boxUuid = boxUuidOpt.get();
//                        SongSettings songSettings = GPM.getValues().getSongSettings().get(boxUuid);
//                        if (songSettings == null) return "";
//                        return songSettings.getSong().getTitle();
//                    }
//                    else {
//                        return "";
//                    }
//                }
//                case "author": {
//                    if (GPM.getValues().getJukeBlocks().size() == 0) return "";
//
//                    Optional<UUID> boxUuidOpt = GPM.getValues().getJukeBlocks().keySet().stream().findFirst();
//                    if (boxUuidOpt.isPresent()) {
//                        UUID boxUuid = boxUuidOpt.get();
//                        SongSettings songSettings = GPM.getValues().getSongSettings().get(boxUuid);
//                        if (songSettings == null) return "";
//                        String originalAuthor = songSettings.getSong().getOriginalAuthor();
//                        return !originalAuthor.isBlank() ? originalAuthor : "Unknown";
//                    }
//                    else {
//                        return "";
//                    }
//                }
//            }
//        }
//
//		if(Player == null || !Player.isOnline()) return null;
//
//		if(Identifier.startsWith("options_")) {
//
//			PlaySettings PS = GPM.getValues().getPlaySettings().get(Player.getUniqueId());
//
//			if(PS != null) {
//
//				switch(Identifier.substring(Identifier.indexOf("_") + 1)) {
//				case "volume": return PS.getVolume() + "%";
//				case "join": return GPM.getMManager().getMessage(PS.isPlayOnJoin() ? "MusicGUI.music-options-true" : "MusicGUI.music-options-false");
//				case "playmode": return "" + PS.getPlayMode();
//				case "particles": return GPM.getMManager().getMessage(PS.isShowingParticles() ? "MusicGUI.music-options-true" : "MusicGUI.music-options-false");
//				case "reverse": return GPM.getMManager().getMessage(PS.isReverseMode() ? "MusicGUI.music-options-true" : "MusicGUI.music-options-false");
//				case "toggle": return GPM.getMManager().getMessage(PS.isToggleMode() ? "MusicGUI.music-options-true" : "MusicGUI.music-options-false");
//				}
//
//			}
//
//		} else if(Identifier.startsWith("active")) {
//
//			SongSettings SS = GPM.getValues().getSongSettings().get(Player.getUniqueId());
//
//			if(Identifier.equals("active")) return GPM.getMManager().getMessage(SS != null ? "MusicGUI.music-options-true" : "MusicGUI.music-options-false");
//
//			switch(Identifier.substring(Identifier.indexOf("_") + 1)) {
//			case "title": return SS != null ? SS.getSong().getTitle() : "";
//			case "id": return SS != null ? SS.getSong().getId() : "";
//			case "author": return SS != null ? SS.getSong().getAuthor().equals("") ? GPM.getMManager().getMessage("MusicGUI.disc-empty-author") : SS.getSong().getAuthor() : "";
//			case "oauthor": return SS != null ? SS.getSong().getOriginalAuthor().equals("") ? GPM.getMManager().getMessage("MusicGUI.disc-empty-oauthor") : SS.getSong().getOriginalAuthor() : "";
//			case "description": return SS != null ? SS.getSong().getDescription().toString() : "";
//			case "length": return SS != null ? GPM.getUtilFormat().convertTime(SS.getSong().getLength()) : "";
//			case "position": return SS != null ? GPM.getUtilFormat().convertTime(SS.getPosition()) : "";
//			case "paused": return GPM.getMManager().getMessage(SS == null | SS.isPaused() ? "MusicGUI.music-options-true" : "MusicGUI.music-options-false");
//
//			}
//
//		}
//
//		return null;
//
//	}
//
//}