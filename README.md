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
make logs
```

## Development

### 開発中に入力補完が効かなくなったら

```
gradle eclipse
```

## Graceful Shutdown

```
make gs
```
