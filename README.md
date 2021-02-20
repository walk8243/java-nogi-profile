# java-nogi-profile

Nogizaka46 Profile JAVA Appication

## Usage

このリポジトリでは、開発時の実行環境としてDockerを使用しています。
また、実行コマンドは全て [make](https://www.gnu.org/software/make/) を使用しています。

### 実行

```
make up
```

### ログの確認

```
make log
```

## Graceful Shutdown

`make up` の実行時にプロセスの一覧が表示されます。
`[PID]` をそこで表示されているPIDに置き換えて実行してください。

```
docker exec web kill [PID]
```
