ECHO = echo
SRC_PATH =

atcoder/new:
	cp -R src/main/java/atcoder/template/ src/main/java/atcoder/$(CONTEST)/
	find src/main/java/atcoder/$(CONTEST)/ -type f  | xargs -I%% sed -i '' -e "s/template/$(CONTEST)/g" %%
